package com.suning.cn.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("收货地址")
public class AddressVo implements Serializable {
    @ApiModelProperty(value = "收货人")
    private String reciver;
    @ApiModelProperty(value = "手机号码")
    private String phone;
    @ApiModelProperty(value = "地区")
    private String region;
    @ApiModelProperty(value = "详细地址")
    private String address;
}
