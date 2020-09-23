package com.suning.cn.service;

import com.suning.cn.params.OrderParam;
import com.suning.cn.utils.ReturnResult;

public interface OrdersService {

    ReturnResult homePage(String typeId);

    ReturnResult getGoodsDetail(String goodsId);

    ReturnResult generatorOrder(OrderParam goodsParam);
}
