package com.suning.cn.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class OrderDetailVo {
    @ApiModelProperty(value = "订单编号")
    private String orderId;
    @ApiModelProperty(value = "收货地址")
    private AddressVo addressVo;
    @ApiModelProperty(value = "商品信息")
    private GoodsVo goodsVo;
    @ApiModelProperty(value = "订单状态（0待支付/1待收货/2已完成")
    private Integer isDel;
    @ApiModelProperty(value = "商品总价")
    private Double totalCost;
    @ApiModelProperty(value = "实付金额")
    private Double realPay;
    @ApiModelProperty(value = "下单时间")
    private Date createTime;
}
