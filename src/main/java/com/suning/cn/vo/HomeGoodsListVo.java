package com.suning.cn.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author tangchaochao
 * @create 2020-2020-09-24 13:48
 */
@Data
@ApiModel(value = "导航栏")
public class HomeGoodsListVo {

    @ApiModelProperty("类型")
    private String type;

    @ApiModelProperty("类型所对应的数据")
    private List<HomeGoodsVo> homeGoodsVo;

}
