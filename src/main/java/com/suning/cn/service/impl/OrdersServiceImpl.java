package com.suning.cn.service.impl;

import com.google.common.collect.Lists;
import com.suning.cn.dto.*;
import com.suning.cn.mapper.*;
import com.suning.cn.params.*;
import com.suning.cn.service.OrdersService;
import com.suning.cn.utils.*;
import com.suning.cn.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private RelationalShopMapper rSMapper;
    @Autowired
    private ShippingAddressMapper addressMapper;
    @Autowired
    private ShopsMapper shopsMapper;
    @Autowired
    private GoodsStockMapper stockMapper;
    @Autowired
    private RedisUtils redisUtils;


    @Override
    public ReturnResult generatorOrder(GoodsParam[] goodsParams, String userId) {
        OrderVo orderVo = new OrderVo();
        List<GoodsVo> goodsVoList = Lists.newArrayList();
        Orders order = new Orders();
        AddressVo addressVo = new AddressVo();
        // 根据用户id获取地址等信息
        ShippingAddress address = addressMapper.selectByPrimaryKey(userId);
        BeanUtils.copyProperties(address, addressVo);
        //生成orderId
        String orderId = UUIDUtils.get12UUID();
        orderVo.setOrderId(orderId);
        //id为key，存redis,0:未支付
        redisUtils.set(orderId, "0");


        // 商品信息
        Double totalCost = 0.0;
        for (GoodsParam goodsParam : goodsParams) {
            GoodsVo goodsVo = new GoodsVo();
            String goodsId = goodsParam.getGoodsId();
            Goods good = goodsMapper.selectByPrimaryKey(goodsId);
            //获取商品库存
            int stock = stockMapper.selectByPrimaryKey(goodsId).getGoodsNum();
            if (stock < goodsParam.getCount()) {
                return ReturnResultUtils.returnFail(737, good.getGoodsName() + "商品库存不足");
            }

            BeanUtils.copyProperties(good, goodsVo);
            try {
                goodsVo.setShops_name(
                        shopsMapper.selectByPrimaryKey(
                                rSMapper.selectByPrimaryKey(goodsId).getShopId()
                        ).getShopsName()
                );
            } catch (Exception e) {
                return ReturnResultUtils.returnFail(747, good.getGoodsName() + "无店家售卖");
            }
            goodsVo.setCount(goodsParam.getCount());
            double cost = goodsVo.getCount() * goodsVo.getOffPrice();
            DecimalFormat df = new DecimalFormat("#.00");

            totalCost += Double.valueOf(df.format(cost));
            goodsVoList.add(goodsVo);
        }
        orderVo.setGoodsVo(goodsVoList);
        orderVo.setAddressVo(addressVo);
        orderVo.setIsDel(0);
        orderVo.setTotalCost(totalCost);
        orderVo.setOffCost(0.0);
        orderVo.setRealPay(orderVo.getTotalCost() - orderVo.getOffCost());

        return ReturnResultUtils.returnSuccess(orderVo);
    }
}
