package com.suning.cn.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

@Data
@ApiModel(value = "购物车表")
public class CartVo implements Serializable {

    @ApiModelProperty("店铺id")
    private String shopsId;

    @ApiModelProperty("店铺名")
    private String shopsName;

    @ApiModelProperty("商品id")
    private String goodsId;

    @ApiModelProperty("商品主图")
    private String goodsPic;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("0:原价/1:打折价")
    private Integer priceType;

    @ApiModelProperty("商品价格")
    private Double cartPrice;

    @ApiModelProperty("商品数量")
    private Integer goodsNum;

    @ApiModelProperty("最大可购买商品的数量，最大值为99")
    private Integer goodsStock;

}