package com.suning.cn.controller;

import com.suning.cn.config.api.LoginRequired;
import com.suning.cn.params.GoodsParam;
import com.suning.cn.service.OrdersService;
import com.suning.cn.utils.ReturnResult;
import com.suning.cn.utils.ReturnResultUtils;
import com.suning.cn.vo.OrderVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/suning")
@Api(tags = "订单接口")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    /**
     * 查看用户所有订单
     */
    @LoginRequired
    @ApiOperation(value = "查看用户所有订单", notes = "参数用户id")
    @PostMapping(value = "/showAllOrders")
    public ReturnResult showAllOrders(@RequestBody String userId) {
        try {
            return ordersService.showAllOrders(userId);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(767, "加载订单失败");
        }
    }

    /**
     * 查看订单详情
     */
    @LoginRequired
    @ApiOperation(value = "查看某个订单详情", notes = "参数orderId")
    @PostMapping(value = "/showOrderDetail")
    public ReturnResult showOrderDetail(@RequestBody String orderId) {
        try {
            return ordersService.showOrderDetail(orderId);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(710, "加载订单失败");
        }
    }


    /**
     * 生成待支付订单（）
     * <p>
     * 根据参数生成待支付订单，返回结果
     * 前台需要：商品信息(店铺名)；订单：数量、总额；用户：收货地址；
     *
     * @param goodsParams 订单信息参数，包含goodsId，price，count
     * @return
     */
    @LoginRequired
    @ApiOperation(value = "生成未支付订单", notes = "goodParams参数为对象数组")
    @PostMapping(value = "/confirm")
    public ReturnResult generatorOrder(@RequestParam @ApiParam(value = "用户id") String userId, @RequestBody @ApiParam(value = "购物车的商品集合") GoodsParam... goodsParams) {
        //return ordersService.generatorOrder(orderParam);
        try {
            return ordersService.generatorOrder(goodsParams, userId);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(707, "订单生成失败");
        }
    }

    /**
     * 用户点击支付
     * 模拟支付接口，将生成的订单存入数据库，等待用户支付信息
     *
     * @param orderVo 参数包含商品信息，店铺名，订单信息，收货地址
     *                用户点支付之后执行该方法
     *                需要
     */
    @LoginRequired
    @ApiOperation(value = "前往支付", notes = "本方法为模拟支付接口前往支付部分，对应小程序前往微信支付，需要生成未支付订单的返回结果")
    @PostMapping(value = "toPay")
    public ReturnResult toPay(@RequestBody OrderVo orderVo) {
        try {
            return ordersService.toPay(orderVo);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(757, "订单生成异常，请重试");
        }
    }


    /**
     * 用户确认支付
     * <p>
     * 传递orderId
     * 模拟微信支付接口，回调本函数
     */
    @LoginRequired
    @ApiOperation(value = "确认支付", notes = "本方法为模拟用户支付成功回调部分，需要返回的订单编号orderId[s]，从上一部前往支付的返回值获取")
    @PostMapping(value = "/getPay")
    public ReturnResult orderGetPayed(@RequestBody String... orderIds) {
        try {
            return ordersService.setOrderGetPayed(orderIds);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(709, "订单状态异常，请联系客服xxx");
        }
    }

    /**
     * 用户确认收货
     * 参数 orderId
     */
    @LoginRequired
    @ApiOperation(value = "用户确认收货")
    @PostMapping(value = "/getReceived")
    public ReturnResult orderGetReceived(@RequestBody String orderId) {
        try {
            return ordersService.setOrderGetReceived(orderId);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(709, "订单状态异常，请联系客服xxx");
        }
    }
}
