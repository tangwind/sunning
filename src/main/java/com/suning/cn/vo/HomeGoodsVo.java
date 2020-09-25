package com.suning.cn.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tangchaochao
 * @create 2020-2020-09-22 10:45
 */
@Data
@ApiModel("首页商品表")
public class HomeGoodsVo implements Serializable {


    @ApiModelProperty("拇指图")
    private String thumbImg;

    @ApiModelProperty("店铺名")
    private String shopName;

    @ApiModelProperty("商品名")
    private String goodsName;

    @ApiModelProperty("商品id")
    private String goodsId;

    @ApiModelProperty("商品价格")
    private Double initPrice;

    @ApiModelProperty("商品评论总数")
    private Integer totalReviews;

}
