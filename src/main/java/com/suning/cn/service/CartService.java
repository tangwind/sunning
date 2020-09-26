package com.suning.cn.service;

import com.suning.cn.params.CartDelParam;
import com.suning.cn.params.CartParam;
import com.suning.cn.vo.CartVo;

import java.util.List;

/**
 * Created by  lzy  on 2020/9/23 15:02
 */
public interface CartService {


    List<CartVo> selectGoodsInfo(String userId);

    String addToCart(CartParam cartParam);

    String updateGoodsNum(CartParam cartParam);

    boolean isDel(CartDelParam... cartDelParams);

}
