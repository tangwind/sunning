package com.suning.cn.controller;

import com.suning.cn.service.AddressService;
import com.suning.cn.vo.AddressVo;
import com.suning.cn.vo.UsersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 收货地址管理
 */
@RestController
@RequestMapping(value = "/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    //查询收货地址
    @ResponseBody
    @PostMapping(value = "/selectAddress")
    public List<AddressVo> selectAddress() {
        List<AddressVo> addressVos = addressService.selectAddress();
        return addressVos;
    }

    //插入收货地址
    @PostMapping(value = "/insertAddress")
    public String insertAddress(@RequestBody AddressVo addressVo) {
        String result = addressService.insertAddress(addressVo);
        return result;
    }
    //修改收货地址
    @PostMapping(value = "/updateAddress")
    public String updateAddress(@RequestBody AddressVo addressVo) {
        String result = addressService.updateAddress(addressVo);
        return result;
    }
    //删除收货地址
    @PostMapping(value = "/deleteAddress")
    public String deleteAddress(@RequestParam("userId") String userId) {
        String result = addressService.deleteAddress(userId);
        return result;
    }
}
