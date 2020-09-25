package com.suning.cn.controller;

import com.suning.cn.service.HomeService;
import com.suning.cn.utils.PageUtils;
import com.suning.cn.utils.ReturnResult;
import com.suning.cn.utils.ReturnResultUtils;
import com.suning.cn.vo.HomeGoodsVo;
import io.swagger.annotations.*;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author tangchaochao
 * @create 2020-2020-09-22 09:33
 * 444:精选商品异常
 * 456:搜索商品错误
 */
@Api(tags = "主页接口")
@Log4j
@RestController
@RequestMapping(value = "/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @ApiOperation(value = "商品搜索接口")
    @PostMapping(value = "/search")
    public ReturnResult<HomeGoodsVo> searchGoods(@RequestParam @ApiParam(value = "搜索内容", required = true) String content,
                                                 @RequestParam @ApiParam(value = "当前页码", required = true) Integer pageNo,
                                                 @RequestParam @ApiParam(value = "每页条数", required = true) Integer pageSize) {
        try {
            PageUtils<HomeGoodsVo> homeGoodsVos = homeService.searchGoods(content, pageNo, pageSize);
            return ReturnResultUtils.returnSuccess(homeGoodsVos);
        } catch (Exception e) {
            log.error("首页商品搜索发生异常: " + new Date() + e);
        }
        return ReturnResultUtils.returnFail(456, "搜索商品错误");
    }

    @ApiOperation(value = "商品分类接口", notes = "精选:10001/食品:10002/母婴:10003/个护清洁:10004/小家电:10005/服饰:10006/苏宁健康:10007/鞋靴:10008/钟表眼镜:10009/饰品:10010")
    @PostMapping(value = "/goods")
    public ReturnResult<HomeGoodsVo> chosen(@RequestParam @ApiParam(value = "当前页码", required = true) Integer pageNo,
                                            @RequestParam @ApiParam(value = "每页条数", required = true) Integer pageSize,
                                            @RequestParam @ApiParam(value = "类型,如:精选、食品...填对应的数字") String type) {
        try {
            PageUtils<HomeGoodsVo> homeGoodsVos = homeService.getChosenGoods(pageNo, pageSize, type);
            return ReturnResultUtils.returnSuccess(homeGoodsVos);
        } catch (Exception e) {
            log.error("首页类型商品获取发生异常: " + new Date() + e);
        }
        return ReturnResultUtils.returnFail(444, "商品类别出错");
    }



}
