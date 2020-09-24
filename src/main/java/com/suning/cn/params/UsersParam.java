package com.suning.cn.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UsersParam implements Serializable {
    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("用户头像")
    private String photoHead;
    @ApiModelProperty("用户昵称")
    private String nickName;
    @ApiModelProperty("性别 （0-未知、1-男、2-女）")
    private Integer gender;
}
