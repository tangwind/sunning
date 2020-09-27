package com.suning.cn.service;

import com.suning.cn.params.AddressParam;
import com.suning.cn.utils.ReturnResult;
import com.suning.cn.vo.AddressVo;

import java.util.List;

public interface AddressService {


    ReturnResult insertAddress(AddressParam addressParam);

    ReturnResult updateAddress(AddressParam addressParam, String addressId);

    ReturnResult deleteAddress(String userId, String addressId);

    List<AddressVo> selectAddress(String userId);
}
