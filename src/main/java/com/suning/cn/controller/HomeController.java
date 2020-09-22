package com.suning.cn.controller;

import com.suning.cn.service.HomeService;
import com.suning.cn.utils.PageUtils;
import com.suning.cn.utils.ReturnResult;
import com.suning.cn.utils.ReturnResultUtils;
import com.suning.cn.vo.home.HomeGoodsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tangchaochao
 * @create 2020-2020-09-22 09:33
 */
@Api(tags = "主页接口")
@Log4j
@RestController
@RequestMapping(value = "/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @ApiOperation(value = "精选商品")
    @PostMapping(value = "/chosen")
    public ReturnResult<HomeGoodsVo> chosen(@RequestParam @ApiParam(value = "当前页码", required = true) Integer pageNo,
                                            @RequestParam @ApiParam(value = "每页条数", required = true) Integer pageSize) {
        try {
            PageUtils<HomeGoodsVo> homeGoodsVos= homeService.getChosenGoods(pageNo, pageSize);
            return ReturnResultUtils.returnSuccess(homeGoodsVos);
        } catch (Exception e) {
            log.error("精选商品发生异常: " + e);
        }
        return ReturnResultUtils.returnFail(444);
    }


}
