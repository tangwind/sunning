package com.suning.cn.controller;

import com.suning.cn.service.UsersService;
import com.suning.cn.vo.UsersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户信息管理
 */
@RestController
@RequestMapping(value = "/user")
public class UsersController {
    @Autowired
    private UsersService usersService;

    //查询用户信息
    @GetMapping(value = "/getUser")
    public List<UsersVo> getUser(String userId) {
        List<UsersVo> userInfo = usersService.getUserInfo(userId);
        return userInfo;
    }

    //插入用户信息
    @PostMapping(value = "/insertUser")
    public String insertUser(@RequestBody UsersVo usersVo) {
        int result = usersService.insertUserInfo(usersVo);
        if (result <= 0) {
            return "false to insert userInfo";
        } else {
            return "success insert";
        }
    }
}
