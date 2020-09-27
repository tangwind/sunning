package com.suning.cn.controller;

import com.suning.cn.config.api.LoginRequired;
import com.suning.cn.params.AddressParam;
import com.suning.cn.service.AddressService;
import com.suning.cn.utils.ReturnResult;
import com.suning.cn.utils.ReturnResultUtils;
import com.suning.cn.vo.AddressVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 收货地址管理
 */
@RestController
@Api(tags = "收货地址接口")
@RequestMapping(value = "/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    //查询收货地址
    @LoginRequired
    @ApiOperation(value = "查看自己的收货地址")
    @ResponseBody
    @PostMapping(value = "/selectAddress")
    public ReturnResult selectAddress(@ApiParam(value = "用户id", required = true) @RequestParam("userId") String userId) {
        try {
            List<AddressVo> addressVos = addressService.selectAddress(userId);
            if (addressVos.size() == 0) {
                return ReturnResultUtils.returnSuccess("您尚未添加收货地址");
            }
            return ReturnResultUtils.returnSuccess(addressVos);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(818, "查询收货地址异常");
        }
    }

    //插入收货地址
    @LoginRequired
    @ApiOperation(value = "添加收货地址")
    @PostMapping(value = "/insertAddress")
    public ReturnResult insertAddress(@RequestBody @ApiParam(value = "收货地址信息", required = true) AddressParam addressParam) {
        ReturnResult result = addressService.insertAddress(addressParam);
        return result;

    }

    //修改收货地址
    @LoginRequired
    @ApiOperation(value = "修改收货地址")
    @PostMapping(value = "/updateAddress")
    public ReturnResult updateAddress(@RequestBody @ApiParam(value = "收货地址信息", required = true) AddressParam addressParam,
                                      @RequestParam @ApiParam(value = "地址id", required = true) String addressId) {
        ReturnResult result = addressService.updateAddress(addressParam, addressId);
        return result;
    }

    //删除收货地址
    @LoginRequired
    @ApiOperation(value = "删除地址")
    @PostMapping(value = "/deleteAddress")
    public ReturnResult deleteAddress(@RequestParam("userId") @ApiParam(value = "用户id", required = true) String userId,
                                      @ApiParam(value = "地址id", required = true) @RequestParam("addressId") String addressId) {
        ReturnResult result = addressService.deleteAddress(userId,addressId);
        return result;
    }
}
