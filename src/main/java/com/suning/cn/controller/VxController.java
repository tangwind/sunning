package com.suning.cn.controller;

import com.alibaba.fastjson.JSONObject;
import com.suning.cn.config.vxconfig.VxConfig;
import com.suning.cn.cons.RedisNameSpace;
import com.suning.cn.dto.Users;
import com.suning.cn.params.UsersInfoParam;
import com.suning.cn.params.UsersParam;
import com.suning.cn.service.UsersService;
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
    private VxConfig vxConfig;

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private UsersService usersService;

    @ApiOperation(value = "获取用户登录信息")
    @RequestMapping(value = "/callBack")
    public String queryUserInfo(@RequestParam @ApiParam(value = "code") String code,
                                @RequestParam @ApiParam(value = "用户信息") UsersInfoParam usersInfoParam){
        try {
            //1、通过code换取网页授权access_token和openid
            String callBackStr = HttpClientUtils.doGet(vxConfig.getAccessToken(code));
            JSONObject jsonObject = JSONObject.parseObject(callBackStr);
            String openId = jsonObject.getString("openid");

           /* //3、如果需要，可以刷新网页授权access_token，避免过期
            String refreshToken = jsonObject.getString("refresh_token");
            HttpClientUtils.doGet(vxConfig.refreshTokenInfo(refreshToken));
            //4、通过网页授权access_token和openid获取用户基本信息（支持UnionID机制）
            String access_token = jsonObject.getString("access_token");
            String userInfoStr = HttpClientUtils.doGet(vxConfig.getUserInfo(access_token, openId));*/

            // 存储数据
            JSONObject userInfoObj = JSONObject.parseObject(usersInfoParam.toString());

            redisUtils.set(RedisNameSpace.USERS_NAMESPACE + "Users" + openId, userInfoObj); // 存redis中
            //redisUtils.set()

            // 判断用户是否为首次登陆
            boolean flag = usersService.selectUserInfoById(openId);
            if (!flag) {
                // 注册
                Users users = new Users();
                users.setUserId(userInfoObj.getString("openid"));
                users.setNickName(userInfoObj.getString("nickname"));
                users.setGender(Integer.valueOf(userInfoObj.getString("sex")));
                users.setPhotoHead(userInfoObj.getString("headimgurl"));
                usersService.addUserInfo(users);
                log.info("用户保存成功");
            }
            // 返回openid对应的用户数据，标记为登录状态
            return openId;//   return "redirect:"+"前端地址?userInfo"+ userInfo_str;
        } catch (IOException e) {
            log.info("微信登录异常：{}" + e);
            e.printStackTrace();
        }
        return "redirect:登录异常！";
    }
}
