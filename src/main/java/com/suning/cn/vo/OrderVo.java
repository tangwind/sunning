package com.suning.cn.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("订单数据")
public class OrderVo implements Serializable {
    @ApiModelProperty(value = "订单编号")
    private String orderId;
    @ApiModelProperty(value = "商品数据")
    private List<GoodsVo> goodsVo;
    @ApiModelProperty(value = "商品总价")
    private Double totalCost;
    @ApiModelProperty(value = "优惠金额")
    private Double offCost;
    @ApiModelProperty(value = "应付金额")
    private Double realPay;
    @ApiModelProperty(value = "订单状态（0待支付/1待收货/2已完成")
    private Integer isDel;
    @ApiModelProperty(value = "收货地址")
    private AddressVo addressVo;
}
