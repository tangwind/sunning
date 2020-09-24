package com.suning.cn.service.impl;

import com.suning.cn.dto.Orders;
import com.suning.cn.dto.Reviews;
import com.suning.cn.dto.Users;
import com.suning.cn.mapper.OrdersMapper;
import com.suning.cn.mapper.ReviewsMapper;
import com.suning.cn.mapper.UsersMapper;
import com.suning.cn.params.ReviewsParam;
import com.suning.cn.params.UsersParam;
import com.suning.cn.service.UsersService;
import com.suning.cn.utils.ReturnResult;
import com.suning.cn.utils.ReturnResultUtils;
import com.suning.cn.vo.UsersVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired(required = false)
    private UsersMapper usersMapper;

    @Autowired(required = false)
    private ReviewsMapper reviewsMapper;

    @Autowired(required = false)
    private OrdersMapper ordersMapper;

    @Override
    public UsersVo getUserInfo(String userId) {
        UsersVo usersVo = new UsersVo();
        Users users = usersMapper.selectByPrimaryKey(userId);
        BeanUtils.copyProperties(users, usersVo);
        return usersVo;
    }

    @Override
    public int insertUserInfo(UsersParam usersParam) {
        Users users = new Users();
        BeanUtils.copyProperties(usersParam, users);
        users.setCreateTime(new Date());
        users.setModifyTime(new Date());
        int result = usersMapper.insertSelective(users);
        return result;
    }

    @Override
    public String updateUserInfo(UsersParam usersParam) {
        Users users = new Users();
        BeanUtils.copyProperties(usersParam, users);
        users.setModifyTime(new Date());
        int result = usersMapper.updateByPrimaryKeySelective(users);
        if (result <= 0) {
            return "update fail";
        }
        return "update success";
    }

    @Override
    public ReturnResult uploadHeadPic(String userId, String filename) {
        Users users = usersMapper.selectByPrimaryKey(userId);
        if (users == null) {
            return ReturnResultUtils.returnFail(999, "查无此号");
        }
        Date time = new Date();
        int rows = usersMapper.uploadHeadPic(userId, filename, time);
        if (rows <= 0) {
            return ReturnResultUtils.returnFail(996, "未知原因，上传错误，头像更新失败");
        }
        return ReturnResultUtils.returnSuccess("头像更新成功");
    }

    @Override
    public ReturnResult insertReviewInfo(ReviewsParam reviewsParam, String fileName) {
        String orderId = reviewsParam.getOrderId();
        Orders orders = ordersMapper.selectByPrimaryKey(orderId);
        int isDel = orders.getIsDel();
        if (isDel == 2) {
            Reviews reviews = new Reviews();
            BeanUtils.copyProperties(reviewsParam, reviews);
            reviews.setUserId(orders.getUserId());
            reviews.setGoodsId(orders.getGoodsId());
            reviews.setCreateTime(new Date());
            reviews.setImages(fileName);
            int result = reviewsMapper.insertReviewInfo(reviews);
            if (result <= 0) {
                return ReturnResultUtils.returnFail();
            }
            return ReturnResultUtils.returnSuccess("评价结束，大佬辛苦");
        } else if (isDel == 1) {
            return ReturnResultUtils.returnFail(640, "您还没有确认收货哦~");
        }
        return ReturnResultUtils.returnFail(699, "你还没有付款哦，大佬，多捞哦");
    }

}
