package com.suning.cn.controller;

import com.suning.cn.params.GoodsLimitParam;
import com.suning.cn.service.GoodsInfoService;
import com.suning.cn.utils.PageUtils;
import com.suning.cn.utils.ReturnResult;
import com.suning.cn.utils.ReturnResultUtils;
import com.suning.cn.vo.GoodsInfoVo;
import com.suning.cn.vo.ReviewsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author tangchaochao
 * @create 2020-2020-09-23 09:00
 * 567：商品加载错误
 * 789：显示评论失败
 */
@Api(tags = "商品详情")
@Log4j
@RestController
@RequestMapping(value = "/goods")
public class GoodsInfoController {
    @Autowired
    private GoodsInfoService goodsInfoService;

    @ApiOperation("商品详细信息接口")
    @PostMapping(value = "/getInfo")
    public ReturnResult<GoodsInfoVo> getInfo(@RequestParam @ApiParam(value = "商品id", required = true) String goodsId) {

        try {
            GoodsInfoVo goodsInfoVo = goodsInfoService.getGoodsAllInfo(goodsId);
            return ReturnResultUtils.returnSuccess(goodsInfoVo);
        } catch (Exception e) {
            log.error("获取商品详细信息异常: " + new Date() + e);
        }

        return ReturnResultUtils.returnFail(567, "商品加载错误！");
    }

    @ApiOperation("显示评论接口")
    @PostMapping(value = "/getReview")
    public ReturnResult<ReviewsVo> getReview(@RequestBody @ApiParam GoodsLimitParam goodsParam) {

        try {
            PageUtils<ReviewsVo> reviewsList = goodsInfoService.getReviewsList(goodsParam.getGoodsId(), goodsParam.getPageNo(), goodsParam.getPageSize());
            return ReturnResultUtils.returnSuccess(reviewsList);
        } catch (Exception e) {
            log.error("显示评论: " + e);
        }

        return ReturnResultUtils.returnFail(789, "显示评论失败!");
    }


}


























