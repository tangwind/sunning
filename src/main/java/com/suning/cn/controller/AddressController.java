package com.suning.cn.controller;

import com.suning.cn.params.AddressParam;
import com.suning.cn.service.AddressService;
import com.suning.cn.vo.AddressVo;
import io.swagger.annotations.ApiParam;
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
    public String insertAddress(@RequestBody @ApiParam(value = "收货地址信息", required = true) AddressParam addressParam) {
        String result = addressService.insertAddress(addressParam);
        return result;
    }

    //修改收货地址
    @PostMapping(value = "/updateAddress")
    public String updateAddress(@RequestBody @ApiParam(value = "收货地址信息", required = true) AddressParam addressParam) {
        String result = addressService.updateAddress(addressParam);
        return result;
    }

    //删除收货地址
    @PostMapping(value = "/deleteAddress")
    public String deleteAddress(@RequestParam("userId") @ApiParam(value = "用户id", required = true) String userId) {
        String result = addressService.deleteAddress(userId);
        return result;
    }
}
