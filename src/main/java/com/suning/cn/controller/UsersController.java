package com.suning.cn.controller;

import com.suning.cn.params.ReviewsParam;
import com.suning.cn.params.UsersParam;
import com.suning.cn.service.UsersService;
import com.suning.cn.utils.ReturnResult;
import com.suning.cn.utils.ReturnResultUtils;
import com.suning.cn.vo.UsersVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


/**
 * 用户信息管理
 */
@Log4j
@Api(tags = "用户信息接口")
@RestController
@RequestMapping(value = "/user")
public class UsersController {
    @Autowired
    private UsersService usersService;

    //查询用户信息
    @PostMapping(value = "/getUser")
    public UsersVo getUser(@RequestParam @ApiParam(value = "用户id", required = true) String userId) {
        UsersVo userInfo = usersService.getUserInfo(userId);
        return userInfo;
    }

    //插入用户信息
    @PostMapping(value = "/insertUser")
    public String insertUser(@RequestBody UsersParam usersParam) {
        int result = usersService.insertUserInfo(usersParam);
        if (result <= 0) {
            return "false to insert userInfo";
        } else {
            return "success insert";
        }
    }

    //修改用户信息
    @PostMapping(value = "/updateUser")
    public String updateUser(@RequestBody @ApiParam(value = "用户信息", required = true) UsersParam usersParam) {
        String result = usersService.updateUserInfo(usersParam);
        return result;
    }

    //上传头像
    @PostMapping("/uploadPic")
    public ReturnResult uploadHeadPic(@RequestParam(value = "file") @ApiParam(value = "头像", required = true) MultipartFile file,
                                      @RequestParam @ApiParam(value = "用户id", required = true) String userId) throws IOException {
        //1.确定保存的文件夹
        String realPath = "/usr/local/project/upload";
        log.info("realPath=" + realPath);
        String filename = getFileName(realPath, file);
        //存入数据库
        if (filename == null) {
            return ReturnResultUtils.returnFail(777);
        }
        ReturnResult result = usersService.uploadHeadPic(userId, filename);
        return result;
    }

    @PostMapping("/publishReview")
    public ReturnResult publishReview(@RequestParam @ApiParam(value = "商品编号", required = true) String orderId,
                                      @RequestParam @ApiParam(value = "评论内容", required = true) String content,
                                      @RequestParam @ApiParam(value = "评分", required = true) Integer score,
                                      @RequestParam("file") @ApiParam(value = "图片") MultipartFile file) throws IOException {
        ReviewsParam reviewsParam = new ReviewsParam();
        reviewsParam.setOrderId(orderId);
        reviewsParam.setContent(content);
        reviewsParam.setScore(score);
        String realPath = "/usr/local/project/" + "img";//会在resource下面创建此文件夹
        log.info("realPath=" + realPath);

        String fileName = getFileName(realPath, file);
        ReturnResult result = usersService.insertReviewInfo(reviewsParam, fileName);
        return result;
    }


    public String getFileName(String realPath, MultipartFile file) throws IOException {
        File dirFile = new File(realPath);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        //确定保存的文件名
        String orginalFilename = file.getOriginalFilename();
        int beginIndex = orginalFilename.lastIndexOf(".");
        String suffix = "";
        if (beginIndex != -1) {
            suffix = orginalFilename.substring(beginIndex);
        }
        String fileName = UUID.randomUUID().toString() + suffix;
        //创建文件对象，表示要保存的头像（文件夹，文件名）
        //File realfile = new File(dirFile, fileName);
        File realfile = new File(dirFile+"/"+fileName);
        if (!realfile.exists()){
            try {
                realfile.createNewFile();
                if (!realfile.exists()) {
                    log.info("创建失败");
                    return null;
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        //保存文件
        file.transferTo(realfile);
        return fileName;
    }

}
