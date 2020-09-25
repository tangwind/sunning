package com.suning.cn.service;

import com.suning.cn.params.GoodsParam;
import com.suning.cn.utils.ReturnResult;
import com.suning.cn.vo.OrderVo;


public interface OrdersService {


    ReturnResult generatorOrder(GoodsParam[] goodsParams, String userId);

    ReturnResult setorderGetPaied(String[] orderIds);

    ReturnResult toPay(OrderVo orderVo);

    ReturnResult showAllOrders(String userId);

    ReturnResult showOrderDetail(String orderId);
}
