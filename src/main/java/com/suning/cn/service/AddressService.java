package com.suning.cn.service;

import com.suning.cn.vo.AddressVo;

import java.util.List;

public interface AddressService {
    String insertAddress(AddressVo addressVo);

    String updateAddress(AddressVo addressVo);

    String deleteAddress(String userId);

    List<AddressVo> selectAddress();
}
