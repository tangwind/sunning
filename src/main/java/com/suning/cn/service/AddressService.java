package com.suning.cn.service;

import com.suning.cn.params.AddressParam;
import com.suning.cn.utils.ReturnResult;
import com.suning.cn.vo.AddressVo;

import java.util.List;

public interface AddressService {

    ReturnResult insertAddress(AddressParam addressParam);

    ReturnResult updateAddress(AddressParam addressParam);

    ReturnResult deleteAddress(String userId);

    List<AddressVo> selectAddress(String userId);
}
