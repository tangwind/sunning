package com.suning.cn.service;

import com.suning.cn.params.GoodsParam;
import com.suning.cn.params.OrderParam;
import com.suning.cn.utils.ReturnResult;
import com.suning.cn.vo.OrderVo;


public interface OrdersService {


    ReturnResult generatorOrder(GoodsParam[] goodsParams, String userId);
}
