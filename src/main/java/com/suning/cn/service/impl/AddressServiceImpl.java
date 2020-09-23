package com.suning.cn.service.impl;

import com.suning.cn.dto.ShippingAddress;
import com.suning.cn.mapper.ShippingAddressMapper;
import com.suning.cn.service.AddressService;
import com.suning.cn.vo.AddressVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
}
