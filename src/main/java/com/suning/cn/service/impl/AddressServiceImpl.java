package com.suning.cn.service.impl;

import com.suning.cn.dto.ShippingAddress;
import com.suning.cn.dto.Users;
import com.suning.cn.mapper.ShippingAddressMapper;
import com.suning.cn.service.AddressService;
import com.suning.cn.vo.AddressVo;
import com.suning.cn.vo.UsersVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private ShippingAddressMapper addressMapper;

    @Override
    public String insertAddress(AddressVo addressVo) {
        ShippingAddress address = new ShippingAddress();
        BeanUtils.copyProperties(addressVo,address);
        int result = addressMapper.insertSelective(address);
        if (result <= 0) {
            return "fail";
        }
        return "success";
    }

    @Override
    public String updateAddress(AddressVo addressVo) {
        ShippingAddress address = new ShippingAddress();
        BeanUtils.copyProperties(addressVo,address);
        int result = addressMapper.updateByPrimaryKeySelective(address);
        if (result <= 0) {
            return "fail";
        }
        return "success";
    }

    @Override
    public String deleteAddress(String userId) {
        int result = addressMapper.deleteByPrimaryKey(userId);
        if (result <= 0) {
            return "fail";
        }
        return "success";
    }

    @Override
    public List<AddressVo> selectAddress() {
        List<AddressVo> addressVoList = new ArrayList<>();
        List<ShippingAddress> addresses = addressMapper.selectAddress();
        addresses.forEach(address -> {
            AddressVo addressVo = new AddressVo();
            BeanUtils.copyProperties(address,addressVo);
            addressVoList.add(addressVo);
        });
        return addressVoList;
    }
}
