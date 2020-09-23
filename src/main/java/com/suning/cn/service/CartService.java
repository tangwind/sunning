package com.suning.cn.service;

import com.suning.cn.vo.CartVo;

/**
 * Created by  lzy  on 2020/9/23 15:02
 */
public interface CartService {

    boolean addToCart(CartVo cartVo);

    boolean isDel(CartVo cartVo);

}
