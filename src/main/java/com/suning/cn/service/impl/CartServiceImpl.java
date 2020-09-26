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
import java.util.Date;
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

        if (toCompareMax(cartParam.getGoodsNum())) {
            return CART_NUM;
        }


        if(toCompareStock(cartParam.getGoodsId(), cartParam.getGoodsNum())) {
            return CART_NUM;
        }

        //判断数据库有没有改订单
        CartExample cartExample = new CartExample();
        cartExample.createCriteria().andGoodsIdEqualTo(cartParam.getGoodsId()).andUserIdEqualTo(cartParam.getUserId());
        long cartData = cartMapper.countByExample(cartExample);
        if (cartData > 0) {

            if (cartParam.getGoodsNum() == 0) {
                return CART_FAIL;
            }

            int num = cartMapper.selectNumByGIdAndUId(cartParam.getGoodsId(), cartParam.getUserId());

            Integer updateNum = num + cartParam.getGoodsNum();

            if(toCompareStock(cartParam.getGoodsId(), cartParam.getGoodsNum())) {
                return CART_NUM;
            }

            updateNum(cartParam.getGoodsId(), cartParam.getUserId(), updateNum);
        }

        Cart cart = new Cart();
        BeanUtils.copyProperties(cartParam, cart);
        try {
            int row = cartMapper.insertSelective(cart);
            if (row > 0) {
                return CART_SUCCESS;
            }
        } catch (Exception e) {
            log.info("购物车添加商品异常: " + new Date() + e);
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


        updateNum(cartParam.getGoodsId(), cartParam.getUserId(), cartParam.getGoodsNum());

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
        try {
            int row = cartMapper.updateByUserIdAndGoodsId(userId, goodsId, CART_DEL);
            return row > 0;
        } catch (Exception e) {
            log.error("删除购物车: " + new Date() + e);
        }

        return false;
    }

    public boolean toCompareStock(String goodsId, Integer num) {
        int goodsStock = goodsStockMapper.selectNumByGoodsId(goodsId);
        return num > goodsStock;
    }

    /**
     * 判断传入商品数量是否大于最大购买商品数量
     * @param num
     * @return
     */
    public boolean toCompareMax (Integer num) {
        return num > MAX_NUM;
    }

    /**
     * 跟新购物车中的商品数据
     * @param goodsId
     * @param userId
     * @param num
     * @return
     */
    public String updateNum (String goodsId, String userId, Integer num) {
        try {
            int row = cartMapper.updateStock(goodsId, userId, num);
            if (row > 0) {
                return CART_SUCCESS;
            }
        } catch (Exception e) {
            log.info("更新商品数量异常: " + new Date() + e);
        }
        return CART_FAIL;
    }




}





















