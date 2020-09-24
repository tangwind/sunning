package com.suning.cn.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tangchaochao
 * @create 2020-2020-09-24 11:44
 */
@Data
public class CartParam implements Serializable {

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("商品id")
    private String goodsId;

    @ApiModelProperty("商品数量")
    private Integer goodsNum;

    @ApiModelProperty("商品单价")
    private double cartPrice;

    @ApiModelProperty("0:原价/1:打折价")
    private Integer priceType;

}
