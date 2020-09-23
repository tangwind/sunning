package com.suning.cn.controller;

import com.suning.cn.service.GoodsInfoService;
import com.suning.cn.utils.ReturnResult;
import com.suning.cn.utils.ReturnResultUtils;
import com.suning.cn.vo.GoodsInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author tangchaochao
 * @create 2020-2020-09-23 09:00
 */
@Api(tags = "商品详情")
@Log4j
@RestController
@RequestMapping(value = "/goods")
public class GoodsInfoController {
    @Autowired
    private GoodsInfoService goodsInfoService;

    @ApiOperation("商品详细信息接口")
    @GetMapping(value = "/getInfo")
    public ReturnResult<GoodsInfoVo> getInfo(@RequestParam @ApiParam(value = "商品id", required = true) String goodsId) {

        try {
            GoodsInfoVo goodsInfoVo = goodsInfoService.getGoodsAllInfo(goodsId);
            return ReturnResultUtils.returnSuccess(goodsInfoVo);
        } catch (Exception e) {
            log.error("获取商品详细信息异常: " + new Date() + e);
        }

        return ReturnResultUtils.returnFail(567, "商品加载错误！");
    }
}


























