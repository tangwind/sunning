package com.suning.cn.controller;

import com.suning.cn.config.api.LoginRequired;
import com.suning.cn.params.GoodsParam;
import com.suning.cn.params.OrderParam;
import com.suning.cn.service.OrdersService;
import com.suning.cn.utils.ReturnResult;
import com.suning.cn.utils.ReturnResultUtils;
import com.suning.cn.vo.OrderVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/suning")
@Api(tags = "订单接口")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;


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
    @ApiOperation(value = "生成未支付订单",notes = "goodParams参数为对象数组")
    @PostMapping(value = "/confirm")
    public ReturnResult generatorOrder(@RequestParam String userId, @RequestBody GoodsParam... goodsParams) {
        //return ordersService.generatorOrder(orderParam);
        try {
            return ordersService.generatorOrder(goodsParams, userId);
        }catch (Exception e){
            return ReturnResultUtils.returnFail(707,"订单生成失败");
        }
    }

    /**
     * 购物车生成支付订单（多条支付）
     *
     * 参数包含：商品信息数组，携带对应商品数量，
     */
}
