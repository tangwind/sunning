package com.suning.cn.service.impl;

import com.suning.cn.dto.*;
import com.suning.cn.mapper.*;
import com.suning.cn.params.CartParam;
import com.suning.cn.service.CartService;
import com.suning.cn.vo.CartVo;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import static com.suning.cn.cons.HomeNameSpace.*;

/**
 * Created by  lzy  on 2020/9/23 15:02
 */
@Log4j
@Service

public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private GoodsStockMapper goodsStockMapper;
    @Autowired
    private ShopsMapper shopsMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private ImgExchangeMapper imgExchangeMapper;
    @Autowired
    private RelationalShopMapper relationalShopMapper;


    /**
     * 查询购物车的订单
     * @param userId 用户id
     * @return 商品数量
     */
    @Override
    public List<CartVo> selectGoodsInfo(String userId) {
        log.info("1");
        CartExample cartExample = new CartExample();
        cartExample.createCriteria().andUserIdEqualTo(userId);
        List<Cart> cartList = cartMapper.selectByExample(cartExample);
        List<CartVo> cartVoList = new ArrayList<>();
        if (cartList.isEmpty()) {

            return cartVoList;
        }
        cartList.forEach(cart -> {
            CartVo cartVo = new CartVo();
            BeanUtils.copyProperties(cart, cartVo);
            RelationalShop relationalShop = relationalShopMapper.selectByPrimaryKey(cart.getGoodsId());
            Shops shops = shopsMapper.selectByPrimaryKey(relationalShop.getShopId());
            cartVo.setShopsName(shops.getShopsName());
            cartVo.setShopsId(shops.getShopsId());

            Goods goods = goodsMapper.selectByPrimaryKey(cart.getGoodsId());
            cartVo.setGoodsName(goods.getGoodsName());

            List<String> mainList = imgExchangeMapper.selectImgBygoodsIdAndMain(cart.getGoodsId(), MAIN);
            cartVo.setGoodsPic(mainList.get(GET_MAIN));

            int goodsStock = goodsStockMapper.selectNumByGoodsId(cart.getGoodsId());
            if (goodsStock > MAX_NUM){
                goodsStock = MAX_NUM;
            }
            cartVo.setGoodsStock(goodsStock);
            cartVoList.add(cartVo);
        });

        return cartVoList;
    }

    /**
     * 购物车添加商品
     * @param cartParam
     * @return
     */
    @Override
    public String addToCart(CartParam cartParam) {
        if (cartParam.getGoodsNum() > MAX_NUM) {
            return CART_NUM;
        }

        int goodsStock = goodsStockMapper.selectNumByGoodsId(cartParam.getGoodsId());
        if(cartParam.getGoodsNum() > goodsStock) {
            return CART_NUM;
        }


        Cart cart = new Cart();
        BeanUtils.copyProperties(cartParam, cart);
        int row = cartMapper.insertSelective(cart);
        if (row > 0) {
            return CART_SUCCESS;
        }

        return CART_FAIL;
    }


    /**
     * 修改购物车中的商品数量
     * @param cartParam
     * @return
     */
    @Override
    public String updateGoodsNum(CartParam cartParam) {
        if (cartParam.getGoodsNum() > MAX_NUM) {
            return CART_NUM;
        }

        int goodsStock = goodsStockMapper.selectNumByGoodsId(cartParam.getGoodsId());
        if(cartParam.getGoodsNum() > goodsStock) {
            return CART_NUM;
        }
        int row = cartMapper.updateStock(cartParam.getGoodsId(), cartParam.getUserId(), cartParam.getGoodsNum());
        if (row > 0) {
            return CART_SUCCESS;
        }
        return CART_FAIL;
    }

    /**
     * 删除购物车
     * @param userId 用户id
     * @param goodsId 商品id
     * @return 删除成功true
     */
    @Override
    public boolean isDel(String userId, String goodsId) {
        int row = cartMapper.updateByUserIdAndGoodsId(userId, goodsId, CART_DEL);
        return row > 0;
    }


}





















