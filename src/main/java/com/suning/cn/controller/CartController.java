package com.suning.cn.controller;

import com.suning.cn.service.CartService;
import com.suning.cn.utils.ReturnResult;
import com.suning.cn.utils.ReturnResultUtils;
import com.suning.cn.vo.CartVo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by  lzy  on 2020/9/23 15:01
 */
@Log4j
@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @ApiOperation(value = "添加商品")
    @PostMapping(value = "addToCart")
    public ReturnResult addToCart(CartVo cartVo){
        boolean flag = cartService.addToCart(cartVo);
        if (flag) {
            return ReturnResultUtils.returnSuccess();
        }
        return ReturnResultUtils.returnFail();
    }
    @ApiOperation(value = "删除",notes = "此为逻辑删除，即商品可恢复")
    @PostMapping(value = "isDelCart")
    public ReturnResult isDelCart(CartVo cartVo){
        boolean flag = cartService.isDel(cartVo);
        if (flag) {
            return ReturnResultUtils.returnSuccess();
        }
        return ReturnResultUtils.returnFail();
    }

}
