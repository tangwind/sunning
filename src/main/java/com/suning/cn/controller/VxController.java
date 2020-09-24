package com.suning.cn.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.suning.cn.config.vxconfig.VxConfig;
import com.suning.cn.cons.RedisNameSpace;
import com.suning.cn.dto.Users;
import com.suning.cn.service.UsersService;
import com.suning.cn.utils.HttpClientUtils;
import com.suning.cn.utils.RedisUtils;
import com.suning.cn.utils.ReturnResult;
import com.suning.cn.vo.UsersVo;
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

/**
 * Created by  lzy  on 2020/9/23 9:12
 * 微信登录
 */
@Api(tags ="微信登录接口")
@Log4j
@Controller
@RequestMapping(value = "/vx")
public class VxController {

    @Autowired
    private VxConfig vxConfig;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private UsersService usersService;

    //1、引导用户进入授权页面同意授权，获取code
    @GetMapping("/getCode")
    @ApiOperation(value = "得到用户授权")
    public String getCode() {
        return "redirect:" + vxConfig.getCode();
    }

    @ApiOperation(value = "获取用户登录信息")
    @RequestMapping(value = "/callBack")
    public String queryUserInfo(@RequestParam @ApiParam(value = "用户授权后的参数code") String code){
        try {
            //2、通过code换取网页授权access_token
            String callBackStr = HttpClientUtils.doGet(vxConfig.getAccessToken(code));
            JSONObject jsonObject = JSONObject.parseObject(callBackStr);
            //3、如果需要，可以刷新网页授权access_token，避免过期
            /*String refreshToken = jsonObject.getString("refresh_token");
            HttpClientUtils.doGet(vxConfig.refreshTokenInfo(refreshToken));*/
            //4、通过网页授权access_token和openid获取用户基本信息（支持UnionID机制）
            String access_token = jsonObject.getString("access_token");
            String openId = jsonObject.getString("openid");
            String userInfoStr = HttpClientUtils.doGet(vxConfig.getUserInfo(access_token, openId));
            // 获取数据
            JSONObject userInfoObj = JSONObject.parseObject(userInfoStr);
            Users users = new Users();
            users.setUserId(userInfoObj.getString("openid"));
            users.setNickName(userInfoObj.getString("nickname"));
            users.setGender(Integer.valueOf(userInfoObj.getString("sex")));
            users.setPhotoHead(userInfoObj.getString("headimgurl"));

            // 存储数据
            redisUtils.set(RedisNameSpace.USERS_NAMESPACE+"Users",userInfoStr);
            boolean flag = usersService.selectUserInfoById(openId);
            if (!flag) {
                int row = usersService.addUserInfo(users);
                if (row > 0) {
                    log.info("用户保存成功");
                } else {
                    log.info("用户重复！");
                }
            }
            // todo
            return "redirect:"+"前端接口！！"+ userInfoStr;//   return "redirect:"+"前端地址?userInfo"+ userInfo_str;
        } catch (IOException e) {
            log.info("微信登录异常：{}" + e);
            e.printStackTrace();
        }
        return "redirect:登录异常！";
    }


}
