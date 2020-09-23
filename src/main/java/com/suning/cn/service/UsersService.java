package com.suning.cn.service;

import com.suning.cn.utils.ReturnResult;
import com.suning.cn.vo.UsersVo;


public interface UsersService {

    UsersVo getUserInfo(String userId);

    int insertUserInfo(UsersVo usersVo);

    String updateUserInfo(UsersVo usersVo);

    ReturnResult uploadHeadPic(String userId, String filename);
}
