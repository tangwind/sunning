package com.suning.cn.vo;

import com.suning.cn.utils.UUIDUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tangchaochao
 * @create 2020-2020-09-23 13:42
 */
@Data
@ApiModel("评价表")
public class ReviewsVo implements Serializable {


    @ApiModelProperty("用户头像")
    private String photoHead;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("用户的评价时间")
    private Date createTime;

    @ApiModelProperty("评分 (总五星：1/2/3/4/5)")
    private Integer score;

    @ApiModelProperty("评价内容")
    private String content;

    @ApiModelProperty("评价图片")
    private String images;

}
