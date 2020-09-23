package com.suning.cn.controller;

import com.suning.cn.service.AddressService;
import com.suning.cn.vo.AddressVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 收货地址管理
 */
@RestController
@RequestMapping(value = "/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    //插入收货地址
    @PostMapping(value = "/insertAddress")
    public String insertAddress(@RequestBody AddressVo addressVo) {
        String result = addressService.insertAddress(addressVo);
        return result;
    }
}
