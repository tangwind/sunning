package com.suning.cn.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Random;

/**
 * @author tangchaochao
 * @create 2020-2020-09-23 09:12
 */
@Data
@ApiModel("商品详细信息表")
public class GoodsInfoVo implements Serializable {

    @ApiModelProperty("拇指图")
    private String thumbImg;

    @ApiModelProperty("副图,以;为分隔符")
    private String sideImg;

    @ApiModelProperty("用户一次购买商品的最大数量，最大值为99件")
    private Integer stock;

    @ApiModelProperty("商品id")
    private String goodsId;

    @ApiModelProperty("商品促销价")
    private Double offPrice;

    @ApiModelProperty("商品原价")
    private Double initPrice;

    @ApiModelProperty("月销售数量")
    private int moonSell;

    @ApiModelProperty("店铺名")
    private String shopsName;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("评论总数")
    private int assessCount;

    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("评分 (总五星：1/2/3/4/5)")
    private Integer score;

    @ApiModelProperty("评价内容")
    private String content;

    @ApiModelProperty("评价图片")
    private String images;

    public int getMoonSell() {
        Random random = new Random();
        moonSell = random.nextInt(99999);
        return moonSell;
    }

    public void setMoonSell(int moonSell) {
        this.moonSell = moonSell;
    }

}
