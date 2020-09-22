package com.suning.cn.service;

import com.suning.cn.utils.PageUtils;
import com.suning.cn.vo.home.HomeGoodsVo;

/**
 * @author tangchaochao
 * @create 2020-2020-09-22 10:07
 */
public interface HomeService {

    /**
     * 获取精选商品
     */
    PageUtils<HomeGoodsVo> getChosenGoods(Integer pageNo, Integer pageSize);
}
