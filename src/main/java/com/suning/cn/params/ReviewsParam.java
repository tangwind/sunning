package com.suning.cn.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ReviewsParam implements Serializable {

    @ApiModelProperty("订单编号")
    private String orderId;

    @ApiModelProperty("评分 (总五星：1/2/3/4/5)")
    private Integer score;

    @ApiModelProperty("评价内容")
    private String content;

}
