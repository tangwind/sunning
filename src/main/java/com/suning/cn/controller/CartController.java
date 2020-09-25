package com.suning.cn.controller;

import com.suning.cn.config.api.LoginRequired;
import com.suning.cn.dto.Cart;
import com.suning.cn.params.CartParam;
import com.suning.cn.service.CartService;
import com.suning.cn.utils.ReturnResult;
import com.suning.cn.utils.ReturnResultUtils;
import com.suning.cn.vo.CartVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.suning.cn.cons.HomeNameSpace.CART_NUM;
import static com.suning.cn.cons.HomeNameSpace.CART_SUCCESS;

/**
 * Created by  lzy  on 2020/9/23 15:01
 */
@Api(tags = "购物车接口")
@Log4j
@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @LoginRequired
    @ApiOperation(value = "查看购物车中的商品")
    @PostMapping(value = "/lookCart")
    public ReturnResult selectCartInfo(@RequestBody @ApiParam(value = "用户id", required = true) String userId){
        try {
            List<CartVo> cartVos = cartService.selectGoodsInfo(userId);
            if (!ObjectUtils.isEmpty(cartVos)) {
                return ReturnResultUtils.returnSuccess(cartVos);
            }
            return ReturnResultUtils.returnSuccess("购物车为空！");
        } catch (Exception e) {
            log.error("查看购物车中的商品异常：" + new Date() + e);
        }

        return ReturnResultUtils.returnFail(988, "查看购物车中的商品错误!");
    }

    @LoginRequired
    @ApiOperation(value = "商品加入购物车")
    @PostMapping(value = "/addToCart")
    public ReturnResult addToCart(@RequestBody @ApiParam(value = "购物车参数表", required = true) CartParam cartParam) {
        try {
            String result = cartService.addToCart(cartParam);
            if (CART_SUCCESS.equals(result)) {
                return ReturnResultUtils.returnSuccess("商品添加成功！");
            }

            if (CART_NUM.equals(result)) {
                return ReturnResultUtils.returnFail(986, "非法传参！");
            }

            return ReturnResultUtils.returnFail(981, "商品添加失败！");
        } catch (Exception e) {
            log.error("商品加入购物车异常: " + new Date() + e);
        }
        return ReturnResultUtils.returnFail(908,"添加发生错误！");
    }

    @LoginRequired
    @ApiOperation(value = "更改购物车中的商品数量", notes = "每次更改一个商品")
    @PostMapping(value = "/updateNum")
    public ReturnResult updateGoodsNum(@RequestBody @ApiParam(value = "购物车参数表", required = true) CartParam cartParam){

        String result = cartService.updateGoodsNum(cartParam);

        if (CART_SUCCESS.equals(result)) {
            return ReturnResultUtils.returnSuccess("添加商品成功！");
        }

        if (CART_NUM.equals(result)) {
            return ReturnResultUtils.returnFail(986, "非法传参！");
        }

        return ReturnResultUtils.returnFail(967, result);
    }


    @LoginRequired
    @ApiOperation(value = "删除购物车中的商品")
    @PostMapping(value = "/delCart")
    public ReturnResult isDelCart(@RequestParam @ApiParam(required = true) String userId,
                                  @RequestParam @ApiParam(required = true) String goodsId){
        try {
            boolean flag = cartService.isDel(userId, goodsId);
            if (flag) {
                return ReturnResultUtils.returnSuccess("已删除");
            }
        } catch (Exception e) {
            log.error("删除购物车商品发生异常：" + new Date() + e);
        }
        return ReturnResultUtils.returnFail(908,"删除购物车中的商品失败！");
    }

}
