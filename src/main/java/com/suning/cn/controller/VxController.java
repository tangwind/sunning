package com.suning.cn.controller;


import com.suning.cn.service.VxLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

/**
 * Created by  lzy  on 2020/9/23 9:12
 * 微信登录
 *
 * openid 自己拿
 * userInfo 前端传给我们
 * 通过接口获取当前登录的code -- openid
 * 讲openid添加到自己定义的哦openid中
 * json类型的userinfo转为java对象
 *
 * 生成一个，以token为key，userInfo为value，存到Redis
 */
@Api(tags = "微信登录接口")
@Log4j
@RestController
@RequestMapping(value = "/vx")
public class VxController {

    @Autowired
    private VxLoginService vxLoginService;

    @ApiOperation(value = "获取用户登录信息")
    @PostMapping(value = "/callBack")
    public String queryUserInfo(@RequestParam @ApiParam(value = "code") String code) throws IOException {
        String result = vxLoginService.vxLogin(code);
        log.info("返回信息："+result);
        return result;

    }
}
