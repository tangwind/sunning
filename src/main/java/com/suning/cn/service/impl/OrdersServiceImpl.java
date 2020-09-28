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
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class OrdersServiceImpl extends BaseServiceImpl implements OrdersService {


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
    private OrdersMapper ordersMapper;
    @Autowired
    private RedisUtils redisUtils;


    @Override
    public ReturnResult generatorOrder(GoodsParam[] goodsParams, String userId) {
        OrderVo orderVo = new OrderVo();
        List<GoodsVo> goodsVoList = Lists.newArrayList();
        Orders order = new Orders();
        AddressVo addressVo = new AddressVo();
        // 根据用户id获取地址等信息
        try {
            ShippingAddressExample addressExample = new ShippingAddressExample();
            ShippingAddressExample.Criteria criteria = addressExample.createCriteria();
            //选取默认地址
            criteria.andUserIdEqualTo(userId).andIsDefaultEqualTo(1);
            List<ShippingAddress> addresses = addressMapper.selectByExample(addressExample);
            if (addresses.size()==0){
                criteria.andIsDefaultEqualTo(0);
                addresses = addressMapper.selectByExample(addressExample);
            }
            BeanUtils.copyProperties(addresses.get(0), addressVo);

            //该部分转交去支付部分实现，一个商品对应一个订单
        /*//生成orderId
        String orderId = UUIDUtils.get12UUID();
        orderVo.setOrderId(orderId);
        //id为key，存redis,0:未支付
        redisUtils.set(orderId, "0");*/

            orderVo.setAddressVo(addressVo);
        }catch ( Exception e){
            return ReturnResultUtils.returnFail(705,"收货地址异常");
        }
        orderVo.setIsDel(0);
        orderVo.setOffCost(0.0);
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
            goodsVo.setThumbImg(getImg(goodsId, "1").get(0));
            DecimalFormat df = new DecimalFormat("#.00");
            double cost = Double.valueOf(df.format(goodsVo.getCount() * goodsVo.getOffPrice()));

            totalCost += cost;
            goodsVoList.add(goodsVo);
        }
        orderVo.setGoodsVo(goodsVoList);
        orderVo.setTotalCost(totalCost);
        orderVo.setRealPay(orderVo.getTotalCost() - orderVo.getOffCost());

        return ReturnResultUtils.returnSuccess(orderVo);
    }

    /**
     * 生成订单列表并存数据库
     *
     * @param orderVo
     */
    @Override
    public ReturnResult toPay(OrderVo orderVo) {
        //获取待支付订单的商品列表，循环生成订单，商品订单一一对应
        List<GoodsVo> goodsParams = orderVo.getGoodsVo();
        List<OrdersVo> ordersToPay = Lists.newArrayList();
        for (GoodsVo goodsVo : goodsParams) {
            OrdersVo orderToPayVo = new OrdersVo();
            //获取orderId，作为订单辨识
            String orderId = UUIDUtils.get12UUID();
            Orders order = new Orders();
            order.setOrderId(orderId);
            //存redis待支付状态
            redisUtils.set(orderId, "0");
            //以下逻辑可改为消息中间件完成
            //待支付订单统一属性值
            order.setIsDel(0);
            order.setUserId(orderVo.getAddressVo().getUserId());
            order.setCreateTime(new Date());
            order.setModifyTime(new Date());
            order.setOffCost(0.0);
            order.setAddressId(orderVo.getAddressVo().getAddressId());
            //商品信息对应部分
            order.setGoodsId(goodsVo.getGoodsId());
            order.setCount(goodsVo.getCount());
            order.setTotalCost(goodsVo.getCount() * goodsVo.getOffPrice());
            order.setRealPay(order.getTotalCost() - order.getOffCost());
            BeanUtils.copyProperties(order, orderToPayVo);
            ordersToPay.add(orderToPayVo);
            //订单存数据库
            ordersMapper.insertSelective(order);
        }
        return ReturnResultUtils.returnSuccess(ordersToPay);
    }

    @Override
    public ReturnResult showAllOrders(String userId) {
        OrdersExample ordersExample = new OrdersExample();
        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<Orders> ordersList = ordersMapper.selectByExample(ordersExample);
        List<OrderShowVo> orderShowVoList = Lists.newArrayList();
        for (Orders orders:ordersList){
            //转vo
            OrderShowVo orderShowVo = new OrderShowVo();
            BeanUtils.copyProperties(orders, orderShowVo);
            //塞商品
            GoodsVo goodsVo = new GoodsVo();
            Goods goods = goodsMapper.selectByPrimaryKey(orders.getGoodsId());
            BeanUtils.copyProperties(goods, goodsVo);
            String shopName = "商家已下架商品";
            RelationalShop rS =rSMapper.selectByPrimaryKey(orders.getGoodsId());
            if (!ObjectUtils.isEmpty(rS)){
                String shopId = rS.getShopId();
                shopName = shopsMapper.selectNameByPrimaryKey(shopId);
            }
            goodsVo.setShops_name(shopName);
            goodsVo.setCount(orders.getCount());
            goodsVo.setThumbImg(getImg(orders.getGoodsId(), "1").get(0));
            orderShowVo.setGoodsVo(goodsVo);
            orderShowVoList.add(orderShowVo);
        };
        return ReturnResultUtils.returnSuccess(orderShowVoList);
    }

    @Override
    public ReturnResult showOrderDetail(String orderId) {
        Orders order = ordersMapper.selectByPrimaryKey(orderId);
        //转订单详情vo
        OrderDetailVo detailVo = new OrderDetailVo();
        BeanUtils.copyProperties(order,detailVo);
        // 根据收货地址id获取地址信息
        AddressVo addressVo = new AddressVo();
        ShippingAddressExample addressExample = new ShippingAddressExample();
        ShippingAddressExample.Criteria criteria = addressExample.createCriteria();
        criteria.andAddressIdEqualTo(order.getAddressId());
        List<ShippingAddress> addresses = addressMapper.selectByExample(addressExample);
        if (addresses.size()==0){
            return ReturnResultUtils.returnFail(701,"收货地址已删除");
        }
        BeanUtils.copyProperties(addresses.get(0), addressVo);

        detailVo.setAddressVo(addressVo);
        //塞商品
        GoodsVo goodsVo = new GoodsVo();
        Goods goods = goodsMapper.selectByPrimaryKey(order.getGoodsId());
        BeanUtils.copyProperties(goods, goodsVo);
        String shopName = "商家已下架商品";
        RelationalShop rS =rSMapper.selectByPrimaryKey(order.getGoodsId());
        if (!ObjectUtils.isEmpty(rS)){
            String shopId = rS.getShopId();
            shopName = shopsMapper.selectNameByPrimaryKey(shopId);
        }
        goodsVo.setShops_name(shopName);
        goodsVo.setCount(order.getCount());
        goodsVo.setThumbImg(getImg(order.getGoodsId(), "1").get(0));
        detailVo.setGoodsVo(goodsVo);


        return ReturnResultUtils.returnSuccess(detailVo);
    }

    @Override
    public ReturnResult setOrderGetPayed(String[] orderIds) {
        List<String> orderIdList = Arrays.asList(orderIds);
        orderIdList.forEach(orderId -> {
            //redis修改状态
            redisUtils.set(orderId, 1);
            //数据库更新状态
            Orders order = new Orders();
            order.setOrderId(orderId);
            order.setIsDel(1);
            ordersMapper.updateByPrimaryKeySelective(order);
        });

        return ReturnResultUtils.returnSuccess("订单支付成功");
    }

    @Override
    public ReturnResult setOrderGetReceived(String orderId) {
        //redis修改状态
        redisUtils.set(orderId, 2);
        //数据库更新状态
        Orders order = new Orders();
        order.setOrderId(orderId);
        order.setIsDel(2);
        ordersMapper.updateByPrimaryKeySelective(order);
        return ReturnResultUtils.returnSuccess("收货成功");
    }

}
