package com.suning.cn.service;

import com.suning.cn.utils.ReturnResult;
import com.suning.cn.vo.UsersVo;

import java.util.List;

public interface UsersService {

    List<UsersVo> getUserInfo(String userId);

    int insertUserInfo(UsersVo usersVo);
}
