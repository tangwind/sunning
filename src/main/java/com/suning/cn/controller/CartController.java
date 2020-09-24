package com.suning.cn.controller;

import com.suning.cn.dto.Cart;
import com.suning.cn.service.CartService;
import com.suning.cn.utils.ReturnResult;
import com.suning.cn.utils.ReturnResultUtils;
import com.suning.cn.vo.CartVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by  lzy  on 2020/9/23 15:01
 * 233,"购物车为空！"
 * 301,"购物车添加失败！"
 * 302,"删除失败！"
 */
@Log4j
@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @ApiOperation(value = "查看购物车的商品")
    @PostMapping(value = "/")
    public ReturnResult selectCartInfo(@RequestBody @ApiParam(value = "购物车参数表", required = true) CartVo cartVo){
        List<Cart> carts = cartService.selectGoodsInfo(cartVo.getUserId());
        if (!ObjectUtils.isEmpty(carts)) {
            return ReturnResultUtils.returnSuccess(carts);
        }
        return ReturnResultUtils.returnFail(233,"购物车为空！");
    }

    @ApiOperation(value = "商品加入购物车")
    @PostMapping(value = "addToCart")
    public ReturnResult addToCart(@RequestBody @ApiParam(value = "购物车参数表", required = true) CartVo cartVo) {
        boolean flag = cartService.addToCart(cartVo);
        if (flag) {
            return ReturnResultUtils.returnSuccess("加购成功！");
        }
        return ReturnResultUtils.returnFail(301,"添加失败！");
    }

    @ApiOperation(value = "更改商品数量")
    @PostMapping(value = "updateNum")
    public ReturnResult updateGoodsNum(@RequestBody @ApiParam(value = "购物车参数表", required = true) CartVo... cartVoList){

        List<Cart> cartGoodList = cartService.updateGoodsNum(cartVoList);


        return ReturnResultUtils.returnFail();
    }

    @ApiOperation(value = "删除购物车商品",notes = "此为逻辑删除，即商品可恢复")
    @PostMapping(value = "isDelCart")
    public ReturnResult isDelCart(@RequestBody @ApiParam(value = "购物车参数表", required = true) CartVo cartVo){
        boolean flag = cartService.isDel(cartVo);
        if (flag) {
            return ReturnResultUtils.returnSuccess("已删除");
        }
        return ReturnResultUtils.returnFail(302,"删除失败！");
    }

}
