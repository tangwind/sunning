package com.suning.cn.service.impl;

import com.suning.cn.dto.Goods;
import com.suning.cn.dto.Orders;
import com.suning.cn.dto.ShippingAddress;
import com.suning.cn.mapper.*;
import com.suning.cn.params.OrderParam;
import com.suning.cn.service.OrdersService;
import com.suning.cn.utils.ReturnResult;
import com.suning.cn.utils.ReturnResultUtils;
import com.suning.cn.utils.UUIDUtils;
import com.suning.cn.vo.AddressVo;
import com.suning.cn.vo.GoodsVo;
import com.suning.cn.vo.OrderVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired(required = false)
    private GoodsMapper goodsMapper;
    @Autowired(required = false)
    private OrdersMapper ordersMapper;
    @Autowired(required = false)
    private RelationalShopMapper rSMapper;
    @Autowired(required = false)
    private UsersMapper usersMapper;
    @Autowired(required = false)
    private ShippingAddressMapper addressMapper;
    @Autowired(required = false)
    private ShopsMapper shopsMapper;

    @Override
    public ReturnResult homePage(String typeId) {
        //TODO 查询返回所有分类
        //TODO 查询返回对应分类所有商品（分页）
        //封装实体类并塞入统一返回类，返回结果
        return null;
    }

    @Override
    public ReturnResult getGoodsDetail(String goodsId) {
        //ToDo 查询并返回商品信息列表
        //todo 获取商品库存，设置选择上限(99>stock?99:stock)
        return null;
    }

    @Override
    public ReturnResult generatorOrder(OrderParam orderParam) {
        OrderVo orderVo = new OrderVo();
        Orders order = new Orders();
        GoodsVo goodsVo = new GoodsVo();
        AddressVo addressVo = new AddressVo();
        // 生成订单号
        orderVo.setOrderId("order-" + UUIDUtils.get12UUID());
        // 商品信息
        //根据goodsId获取商品信息
        try {
            Goods good = goodsMapper.selectByPrimaryKey(orderParam.getGoodsId());
            BeanUtils.copyProperties(good, goodsVo);
        }catch (Exception e){
            ReturnResultUtils.returnFail(707);//商品信息错误
        }
        //根据商品id获取店铺名称
        try{
            goodsVo.setShops_name(
                    shopsMapper.selectByPrimaryKey(
                            rSMapper.selectByPrimaryKey(orderParam.getGoodsId()).getShopId()
                    ).getShopsName()
            );
        }catch (Exception e){
            ReturnResultUtils.returnFail(708);//获取店铺名失败
        }
        //ToDo 根据用户id获取地址等信息
        ShippingAddress address = addressMapper.selectByPrimaryKey(orderParam.getUserId());
        BeanUtils.copyProperties(address, addressVo);
        //修改数量时修改总额
        orderVo.setCount(orderParam.getCount());
        orderVo.setIsDel(0);
        orderVo.setTotalCost(orderParam.getCount()*goodsVo.getOffPrice());
        orderVo.setOffCost(0.0);
        orderVo.setRealPay(orderVo.getTotalCost()-orderVo.getOffCost());
        orderVo.setGoodsVo(goodsVo);
        orderVo.setAddressVo(addressVo);

        BeanUtils.copyProperties(orderVo,order);
        System.out.println(order);
        return ReturnResultUtils.returnSuccess(orderVo);
    }
}
