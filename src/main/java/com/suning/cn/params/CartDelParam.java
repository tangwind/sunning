package com.suning.cn.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author tangchaochao
 * @create 2020-2020-09-26 10:03
 */
@Data
public class CartDelParam {
    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("商品id")
    private String goodsId;
}
