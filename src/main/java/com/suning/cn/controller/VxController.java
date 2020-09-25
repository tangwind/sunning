package com.suning.cn.controller;

import com.alibaba.fastjson.JSONObject;
import com.suning.cn.config.vxconfig.VxConfig;
import com.suning.cn.cons.RedisNameSpace;
import com.suning.cn.dto.Users;
import com.suning.cn.params.UsersInfoParam;
import com.suning.cn.params.UsersParam;
import com.suning.cn.service.UsersService;
import com.suning.cn.service.VxLoginService;
import com.suning.cn.utils.HttpClientUtils;
import com.suning.cn.utils.RedisUtils;
import com.suning.cn.utils.ReturnResult;
import com.suning.cn.utils.UUIDUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipal;

import static com.suning.cn.cons.RedisNameSpace.USER_LOGIN;
import static com.suning.cn.cons.RedisNameSpace.USER_LOGIN_TIME;

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
@Controller
@RequestMapping(value = "/vx")
public class VxController {

    @Autowired
    private VxLoginService vxLoginService;

    @ApiOperation(value = "获取用户登录信息")
    @RequestMapping(value = "/callBack")
    public String queryUserInfo(@RequestParam @ApiParam(value = "code") String code) throws IOException {
        return vxLoginService.vxLogin(code);
    }
}
