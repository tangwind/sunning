package com.suning.cn.service.impl;

import com.suning.cn.dto.Users;
import com.suning.cn.mapper.UsersMapper;
import com.suning.cn.service.UsersService;
import com.suning.cn.utils.ReturnResult;
import com.suning.cn.vo.UsersVo;
import org.apache.poi.ss.formula.functions.Now;
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
    public List<UsersVo> getUserInfo(String userId) {
        UsersVo usersVo = new UsersVo();
        Users users = usersMapper.selectByPrimaryKey(userId);
        BeanUtils.copyProperties(users,usersVo);
        return (List<UsersVo>) usersVo;
    }

    @Override
    public int insertUserInfo(UsersVo usersVo) {
        Users users = new Users();
        BeanUtils.copyProperties(usersVo,users);
        users.setCreateTime(new Date());
        int result = usersMapper.insertSelective(users);
        return result;
    }
}
