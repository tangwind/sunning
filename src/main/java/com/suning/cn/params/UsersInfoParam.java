package com.suning.cn.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by  lzy  on 2020/9/24 19:52
 */
@Data
public class UsersInfoParam implements Serializable {
/*    @ApiModelProperty("用户的id")
    private String openid;
    @ApiModelProperty("用户头像")
    private String headimgurl;
    @ApiModelProperty("用户昵称")
    private String nickname;
    @ApiModelProperty("性别 （0-未知、1-男、2-女）")
    private Integer sex;
    */
    @ApiModelProperty("用户头像")
    private String photoHead;
    @ApiModelProperty("用户昵称")
    private String nickName;
    @ApiModelProperty("性别 （0-未知、1-男、2-女）")
    private Integer gender;
}
