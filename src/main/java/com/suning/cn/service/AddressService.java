package com.suning.cn.service;

import com.suning.cn.params.AddressParam;
import com.suning.cn.vo.AddressVo;

import java.util.List;

public interface AddressService {
    String insertAddress(AddressParam addressParam);

    String updateAddress(AddressParam addressParam);

    String deleteAddress(String userId);

    List<AddressVo> selectAddress();
}
