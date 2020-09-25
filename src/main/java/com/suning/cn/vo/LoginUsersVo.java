package com.suning.cn.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author tangchaochao
 * @create 2020-2020-09-25 11:03
 */
@Data
@Api("用户登录表")
public class LoginUsersVo {
    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("性别 （0-未知、1-男、2-女）")
    private Integer gender;
}
