package com.suning.cn.service.impl;

import com.suning.cn.dto.Users;
import com.suning.cn.mapper.UsersMapper;
import com.suning.cn.service.UsersService;
import com.suning.cn.vo.UsersVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired(required = false)
    private UsersMapper usersMapper;
    @Override
    public UsersVo getUserInfo(String userId) {
        UsersVo usersVo = new UsersVo();
        Users users = usersMapper.selectByPrimaryKey(userId);
        BeanUtils.copyProperties(users,usersVo);
        return usersVo;
    }

    @Override
    public int insertUserInfo(UsersVo usersVo) {
        Users users = new Users();
        BeanUtils.copyProperties(usersVo,users);
        users.setCreateTime(new Date());
        users.setModifyTime(new Date());
        int result = usersMapper.insertSelective(users);
        return result;
    }

    @Override
    public String updateUserInfo(UsersVo usersVo) {
        Users users = new Users();
        BeanUtils.copyProperties(usersVo,users);
        users.setModifyTime(new Date());
        int result = usersMapper.updateByPrimaryKeySelective(users);
        if (result <= 0) {
            return "update fail";
        }
        return "update success";
    }
}
