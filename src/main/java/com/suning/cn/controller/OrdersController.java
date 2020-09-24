package com.suning.cn.controller;

import com.suning.cn.params.OrderParam;
import com.suning.cn.service.OrdersService;
import com.suning.cn.utils.ReturnResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/suning")
@Api
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    /**
     * 用户请求主页
     * 返回参数1：类型（头部）
     * 返回参数2：商品列表（主体）:商品名，商品大图，
     */
    public ReturnResult homePage(String typeId) {
        return ordersService.homePage(typeId);
    }

    /**
     * 商品详情页
     * <p>
     * param goodsId 商品id
     * 根据商品id获取商品信息
     * 返回所获结果
     */
    public ReturnResult goodsDetail(String goodsId) {
        return ordersService.getGoodsDetail(goodsId);
    }

    /**
     * 生成待支付订单（单个支付/非购物车）
     * <p>
     * 根据参数生成待支付订单，返回结果
     * 前台需要：商品信息(店铺名)；订单：数量、总额；用户：收货地址；
     *
     * @param orderParam 订单信息参数，包含goodsId，price，count
     * @return
     */
    @PostMapping(value = "/confirm")
    public ReturnResult generatorOrder(@RequestBody OrderParam orderParam) {
        return ordersService.generatorOrder(orderParam);
    }
}
