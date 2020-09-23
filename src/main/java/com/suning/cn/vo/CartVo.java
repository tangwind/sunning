package com.suning.cn.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
@ApiModel
public class CartVo {
    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("商品id")
    private String goodsId;
    @ApiModelProperty("商品数量")
    private Integer goodsNum;
}