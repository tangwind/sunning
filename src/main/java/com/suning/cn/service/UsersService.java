package com.suning.cn.service;

import com.suning.cn.dto.Users;
import com.suning.cn.vo.UsersVo;


public interface UsersService {

    UsersVo getUserInfo(String userId);

    int insertUserInfo(UsersVo usersVo);

    String updateUserInfo(UsersVo usersVo);

    // 微信登录-查询用户id
    boolean selectUserInfoById(String userId);

    int addUserInfo(Users users);
}
