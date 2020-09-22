package com.suning.cn.service.impl;

import com.suning.cn.mapper.GoodsInfoMapper;
import com.suning.cn.mapper.GoodsMapper;
import com.suning.cn.mapper.ReviewsMapper;
import com.suning.cn.service.HomeService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tangchaochao
 * @create 2020-2020-09-22 10:08
 */
@Log4j
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsInfoMapper goodsInfoMapper;
    @Autowired
    private ReviewsMapper reviewsMapper;

    /**
     * 获取精选商品
     */
    @Override
    public void getChosenGoods() {
    }




}
