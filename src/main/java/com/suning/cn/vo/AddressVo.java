package com.suning.cn.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel
@Data
public class AddressVo implements Serializable {
    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("收件人姓名")
    private String reciver;
    @ApiModelProperty("收件人手机号")
    private String phone;
    @ApiModelProperty("收货地区")
    private String region;
    @ApiModelProperty("收货的详细地址")
    private String address;
    @ApiModelProperty("地址的邮编（可不填）")
    private String mailCode;
    @ApiModelProperty("选择默认地址（0-非默认、1-默认）")
    private Integer isDefault;
}
