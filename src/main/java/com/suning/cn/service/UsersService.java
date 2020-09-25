package com.suning.cn.service;

import com.suning.cn.dto.Users;
import com.suning.cn.params.ReviewsParam;
import com.suning.cn.params.UsersParam;
import com.suning.cn.utils.ReturnResult;
import com.suning.cn.vo.UsersVo;


public interface UsersService {

    UsersVo getUserInfo(String userId);

    int insertUserInfo(UsersParam usersParam);

    ReturnResult updateUserInfo(UsersParam usersParam);

    ReturnResult uploadHeadPic(String userId, String filename);

    ReturnResult insertReviewInfo(ReviewsParam reviewsParam, String fileName);

    // 微信登录-查询用户id
    boolean selectUserInfoById(String userId);

    int addUserInfo(Users users);
}
