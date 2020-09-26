package com.suning.cn.service.impl;

import com.suning.cn.dto.*;
import com.suning.cn.mapper.*;
import com.suning.cn.params.CartDelParam;
import com.suning.cn.params.CartParam;
import com.suning.cn.service.CartService;
import com.suning.cn.vo.CartVo;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

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
        cartExample.createCriteria().andUserIdEqualTo(userId).andIsDelEqualTo(CART_NO_DEL);
        List<Cart> cartList = cartMapper.selectByExample(cartExample);
        List<CartVo> cartVoList = new ArrayList<>();
        if (cartList.isEmpty()) {
            return cartVoList;
        }
        cartList.forEach(cart -> {
            CartVo cartVo = new CartVo();
            BeanUtils.copyProperties(cart, cartVo);

            Goods goods = goodsMapper.selectByPrimaryKey(cart.getGoodsId());
            cartVo.setGoodsName(goods.getGoodsName());

            List<String> mainList = imgExchangeMapper.selectImgBygoodsIdAndMain(cart.getGoodsId(), MAIN);
            cartVo.setGoodsPic(mainList.get(GET_MAIN));

            int goodsStock = goodsStockMapper.selectNumByGoodsId(cart.getGoodsId());
            if (goodsStock > MAX_NUM){
                goodsStock = MAX_NUM;
            }
            cartVo.setGoodsStock(goodsStock);

            RelationalShop relationalShop = relationalShopMapper.selectByPrimaryKey(cart.getGoodsId());
            if (!ObjectUtils.isEmpty(relationalShop)) {
                Shops shops = shopsMapper.selectByPrimaryKey(relationalShop.getShopId());
                cartVo.setShopsName(shops.getShopsName());
                cartVo.setShopsId(shops.getShopsId());
            }
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

        //数据不能为空
        if (ObjectUtils.isEmpty(cartParam)) {
            return CART_FAIL;
        }

        //购买数量不能大于最大购买量
        if (toCompareMax(cartParam.getGoodsNum())) {
            return CART_NUM;
        }

        //购买数量不能大于库存
        if(toCompareStock(cartParam.getGoodsId(), cartParam.getGoodsNum())) {
            return CART_NUM;
        }

        //判断购物车中是否存在数据
        if (isCart(cartParam.getGoodsId(), cartParam.getUserId())) {
            String result = updateNumByAddCart(cartParam.getGoodsId(), cartParam.getUserId(), cartParam.getGoodsNum());
            return result;
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

        //数据不能为空
        if (ObjectUtils.isEmpty(cartParam)) {
            return CART_NUM;
        }

        //购买数量不能大于最大购买量
        if (toCompareMax(cartParam.getGoodsNum())) {
            return CART_NUM;
        }

        //购买数量不能大于库存
        if(toCompareStock(cartParam.getGoodsId(), cartParam.getGoodsNum())) {
            return CART_NUM;
        }
        //更新数据
        String result = updateNum(cartParam.getGoodsId(), cartParam.getUserId(), cartParam.getGoodsNum());
        return result;
    }

    /**
     * 删除购物车
     * @param cartDelParams
     * @return
     */
    @Override
    public boolean isDel(CartDelParam... cartDelParams) {

        //传参不能为空
        if (StringUtils.isEmpty(cartDelParams)) {
            return false;
        }

        for (CartDelParam cartDelParam : cartDelParams) {
            try {
                cartMapper.updateByUserIdAndGoodsId(cartDelParam.getUserId(), cartDelParam.getGoodsId(), CART_DEL);
            } catch (Exception e) {
                log.error("删除购物车: " + new Date() + e);
            }
        }

        return true;
    }

    /**
     * 判断购物车中是否存在数据
     * @param goodsId
     * @param userId
     * @return
     */
    public boolean isCart(String goodsId, String userId) {
        CartExample cartExample = new CartExample();
        cartExample.createCriteria().andGoodsIdEqualTo(goodsId).andUserIdEqualTo(userId);
        long cartData = cartMapper.countByExample(cartExample);
        return cartData > 0;
    }

    /**
     * 更新数据
     * @param goodsId
     * @param userId
     * @param goodsNum
     * @return
     */
    public String updateNumByAddCart(String goodsId, String userId, Integer goodsNum) {
        //获取商品数量
        int num = cartMapper.selectNumByGIdAndUId(goodsId, userId);
        Integer updateNum = num + goodsNum;
        //购买数量不能大于库存
        if(toCompareStock(goodsId, updateNum)) {
            return CART_NUM;
        }
        //更新数据
        updateNum(goodsId, userId, updateNum);
        return CART_SUCCESS;
    }

    /**
     * 购买数与库存的比较
     * @param goodsId
     * @param num
     * @return
     */
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





















