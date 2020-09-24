package com.suning.cn.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("商品数据")
public class GoodsVo implements Serializable {
    @ApiModelProperty(value = "商品名称")
    private String goodsName;
    @ApiModelProperty(value = "商品现价/优惠价")
    private Double offPrice;
    @ApiModelProperty(value = "店铺名")
    private String shops_name;
    @ApiModelProperty(value = "商品数量")
    private int count;


}
