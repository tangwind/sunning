package com.suning.cn.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("展示所有订单")
public class OrderShowVo {

    @ApiModelProperty(value = "订单编号")
    private String orderId;
    @ApiModelProperty(value = "商品信息")
    private GoodsVo goodsVo;
    @ApiModelProperty(value = "订单状态（0待支付/1待收货/2已完成")
    private Integer isDel;
    @ApiModelProperty(value = "应付金额")
    private Double realPay;
}
