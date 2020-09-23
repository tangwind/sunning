package com.suning.cn.service.impl;

import com.suning.cn.dto.Cart;
import com.suning.cn.dto.CartExample;
import com.suning.cn.mapper.CartMapper;
import com.suning.cn.service.CartService;
import com.suning.cn.vo.CartVo;
import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by  lzy  on 2020/9/23 15:02
 */
@Log4j
@Service

public class CartServiceImpl implements CartService {

    @Reference
    private CartMapper cartMapper;

    @Override
    public boolean addToCart(CartVo cartVo) {
        Cart cart = new Cart();
        BeanUtils.copyProperties(cartVo, cart);
        int row = cartMapper.insertSelective(cart);
        log.info(row);
        if (row > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isDel(CartVo cartVo) {
        Cart cart = new Cart();
        CartExample cartExample = new CartExample();

        BeanUtils.copyProperties(cartVo, cart);
        // todo 逻辑删除！
        //cartMapper.updateByExampleSelective(cartVo, );

        return false;
    }


}





















