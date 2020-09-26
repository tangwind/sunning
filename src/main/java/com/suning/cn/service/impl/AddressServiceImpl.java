package com.suning.cn.service.impl;

import com.suning.cn.dto.ShippingAddress;
import com.suning.cn.dto.ShippingAddressExample;
import com.suning.cn.dto.Users;
import com.suning.cn.mapper.ShippingAddressMapper;
import com.suning.cn.params.AddressParam;
import com.suning.cn.service.AddressService;
import com.suning.cn.utils.ReturnResult;
import com.suning.cn.utils.ReturnResultUtils;
import com.suning.cn.utils.UUIDUtils;
import com.suning.cn.vo.AddressVo;
import com.suning.cn.vo.UsersVo;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Log4j
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private ShippingAddressMapper addressMapper;

    @Override
    public ReturnResult insertAddress(AddressParam addressParam) {
        ShippingAddress address = new ShippingAddress();
        BeanUtils.copyProperties(addressParam,address);
        String address_id = UUID.randomUUID().toString();
        address.setAddressId(address_id);
        int result = addressMapper.insertSelective(address);
        if (result <= 0) {
            return ReturnResultUtils.returnFail(703,"fail to insert address");
        }
        return ReturnResultUtils.returnSuccess("insert address success");
    }

    @Override
    public ReturnResult updateAddress(AddressParam addressParam) {
        ShippingAddress address = new ShippingAddress();
        BeanUtils.copyProperties(addressParam,address);
        //int result = addressMapper.updateByPrimaryKeySelective(address);
        ShippingAddressExample addressExample = new ShippingAddressExample();
        ShippingAddressExample.Criteria criteria = addressExample.createCriteria();
        criteria.andUserIdEqualTo(address.getUserId());
        int result = addressMapper.updateByExampleSelective(address,addressExample);
        if (result <= 0) {
            return ReturnResultUtils.returnFail(704,"fail to update address");
        }
        return ReturnResultUtils.returnSuccess("update address success");
    }

    @Override
    public ReturnResult deleteAddress(String userId, String addressId) {
        int result = addressMapper.deleteByuserId(userId, addressId);
        if (result <= 0) {
            return ReturnResultUtils.returnFail(705,"fail to del address");
        }
        return ReturnResultUtils.returnSuccess("del address success");
    }

    @Override
    public List<AddressVo> selectAddress(String userId) {
        List<AddressVo> addressVoList = new ArrayList<>();
        List<ShippingAddress> addresses = addressMapper.selectAddress(userId);
        for (ShippingAddress address : addresses){
            AddressVo addressVo = new AddressVo();
            BeanUtils.copyProperties(address,addressVo);
            addressVoList.add(addressVo);
        }
        return addressVoList;
    }

}
