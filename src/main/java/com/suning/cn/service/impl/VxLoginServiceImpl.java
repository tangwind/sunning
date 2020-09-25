package com.suning.cn.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.suning.cn.config.vxconfig.VxConfig;
import com.suning.cn.dto.UsersExample;
import com.suning.cn.mapper.UsersMapper;
import com.suning.cn.service.VxLoginService;
import com.suning.cn.utils.HttpClientUtils;
import com.suning.cn.utils.RedisUtils;
import com.suning.cn.utils.ReturnResult;
import com.suning.cn.utils.ReturnResultUtils;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.suning.cn.cons.RedisNameSpace.USER_LOGIN;
import static com.suning.cn.cons.RedisNameSpace.USER_LOGIN_TIME;
import static com.suning.cn.cons.VxLoginNamespace.REGISTER;

/**
 * @author tangchaochao
 * @create 2020-2020-09-25 09:15
 */
@Log4j
@Service
public class VxLoginServiceImpl implements VxLoginService {

    @Autowired
    private VxConfig vxConfig;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private UsersMapper usersMapper;


    @Override
    public String vxLogin(String code) throws IOException {

        //1、通过code换取网页授权access_token和openid
        String callBackStr = HttpClientUtils.doGet(vxConfig.getOpenid(code));
        JSONObject jsonObject = JSONObject.parseObject(callBackStr);

        log.info(jsonObject);
        String openId = jsonObject.getString("openid");
        redisUtils.set(USER_LOGIN + openId, USER_LOGIN, USER_LOGIN_TIME);
        redisUtils.set(openId, "token");

        int count = usersMapper.countUser(openId);
        if (count == 0) {
            usersMapper.addUser(openId);
        }
        return openId;
    }



}
