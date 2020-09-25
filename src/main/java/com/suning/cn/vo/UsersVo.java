package com.suning.cn.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel("用户表")
public class UsersVo implements Serializable {

    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("用户头像")
    private String photoHead;
    @ApiModelProperty("用户昵称")
    private String nickName;
    @ApiModelProperty("性别 （0-未知、1-男、2-女）")
    private Integer gender;
    @ApiModelProperty("用户账户的创建时间")
    private Date createTime;
    @ApiModelProperty("用户账户的修改时间")
    private Date modifyTime;
}
