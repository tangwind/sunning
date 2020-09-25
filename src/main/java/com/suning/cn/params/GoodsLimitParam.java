package com.suning.cn.params;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;

/**
 * Created by  lzy  on 2020/9/25 15:38
 */
@Data
public class GoodsLimitParam implements Serializable {

    @ApiModelProperty(value = "当前页码")
    private Integer pageNo;
    @ApiModelProperty(value = "每页条数")
    private Integer pageSize;
    @ApiModelProperty(value = "商品id")
    private String goodsId;
}
