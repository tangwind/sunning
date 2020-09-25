package com.suning.cn.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 去支付订单vo
 */
@Data
@ApiModel("支付所需订单信息")
public class OrdersVo {

    @ApiModelProperty(value = "订单号")
    private String orderId;
    @ApiModelProperty(value = "实付款")
    private double realPay;
}
