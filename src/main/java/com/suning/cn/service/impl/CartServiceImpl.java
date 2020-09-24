/*
package com.suning.cn.service.impl;

import com.suning.cn.dto.Cart;
import com.suning.cn.dto.CartExample;
import com.suning.cn.mapper.CartMapper;
import com.suning.cn.params.CartParam;
import com.suning.cn.service.CartService;
import com.suning.cn.vo.CartVo;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

*/
/**
 * Created by  lzy  on 2020/9/23 15:02
 *//*

@Log4j
@Service

public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    //@Override
    //public List<Cart> selectGoodsInfo(String userId) {
    //
    //    CartExample cartExample = new CartExample();
    //    cartExample.createCriteria().andUserIdEqualTo(userId);
    //    List<Cart> cartList = cartMapper.selectCartInfoByExample(cartExample);
    //
    //
    //    return cartList;
    //}
    //
    //@Override
    //public boolean addToCart(CartVo cartVo) {
    //    Cart cart = new Cart();
    //    BeanUtils.copyProperties(cartVo, cart);
    //    int row = cartMapper.insertSelective(cart);
    //    log.info(row);
    //    if (row > 0) {
    //        return true;
    //    }
    //    return false;
    //}

    // 修改数量
    // 不可大于库存量
    // 数量不可小于1
    //@Override
    //public List updateGoodsNum(CartVo... cartVo) {


        //CartExample cartExample = new CartExample();
        //// 根据用户id获取商品数据 可能是一个集合！！
        //cartExample.createCriteria().andUserIdEqualTo(cart.getUserId());
        //List<Cart> cartList = cartMapper.selectCartInfoByExample(cartExample);
        //// 根据商品id 修改商品数量
        //cartMapper.updateNumByGoodId(cart.);
        //// 数量范围判断
        //
        //
        //cartExample.createCriteria();
        //
        //cartMapper.updateByExampleSelective();
        //// 返回是否成功



    //    return ;
    //}

    //@Override
    //public boolean isDel(CartVo cartVo) {
    //    Cart cart = new Cart();
    //    CartExample cartExample = new CartExample();
    //    BeanUtils.copyProperties(cartVo, cart);
    //    cart.setIsDel(0);
    //    cartExample.createCriteria().andUserIdEqualTo(cartVo.getUserId());
    //    // todo 逻辑删除！
    //    int row = cartMapper.updateByExampleSelective(cart, cartExample);
    //    if (row > 0) {
    //        return true;
    //    }
    //
    //    return false;
    //}


}





















*/
