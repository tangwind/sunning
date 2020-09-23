package com.suning.cn.controller;

import com.suning.cn.service.UsersService;
import com.suning.cn.utils.ReturnResult;
import com.suning.cn.vo.UsersVo;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


/**
 * 用户信息管理
 */
@Log4j
@RestController
@RequestMapping(value = "/user")
public class UsersController {
    @Autowired
    private UsersService usersService;

    //查询用户信息
    @PostMapping(value = "/getUser")
    public UsersVo getUser(String userId) {
        UsersVo userInfo = usersService.getUserInfo(userId);
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
    //修改用户信息
    @PostMapping(value = "/updateUser")
    public String updateUser(@RequestBody UsersVo usersVo) {
        String result = usersService.updateUserInfo(usersVo);
        return result;
    }
    //上传头像
    @PostMapping("/uploadPic")
    public ReturnResult uploadHeadPic(@RequestParam(value = "file") MultipartFile file,String userId,
                                      HttpServletRequest request) throws IOException {
        //1.确定保存的文件夹
        String realPath = Thread.currentThread().getContextClassLoader().getResource("").getPath()+"upload";//会在resource下面创建此文件夹
        log.info("realPath="+realPath);

        File dirFile = new File(realPath);
        if(!dirFile.exists()) {
            dirFile.mkdirs();
        }
        //确定保存的文件名
        String orginalFilename = file.getOriginalFilename();
        int beginIndex = orginalFilename.lastIndexOf(".");
        String suffix = "";
        if (beginIndex != -1){
            suffix = orginalFilename.substring(beginIndex);
        }
        String filename = UUID.randomUUID().toString()+suffix;
        //创建文件对象，表示要保存的头像（文件夹，文件名）
        File realfile = new File(dirFile,filename);
        //保存文件
        file.transferTo(realfile);
        //存入数据库
        ReturnResult result = usersService.uploadHeadPic(userId,filename);
        return result;
    }
}
