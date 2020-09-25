package com.suning.cn.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsParam implements Serializable {

    @ApiModelProperty(value = "商品id")
    private String goodsId;
    @ApiModelProperty(value = "商品数量")
    private int count;
}
