package com.suning.cn.service;

import com.suning.cn.utils.PageUtils;
import com.suning.cn.vo.GoodsInfoVo;
import com.suning.cn.vo.ReviewsVo;

/**
 * @author tangchaochao
 * @create 2020-2020-09-23 09:01
 */
public interface GoodsInfoService {


    GoodsInfoVo getGoodsAllInfo(String goodsId);

    PageUtils<ReviewsVo> getReviewsList(String goodsId, Integer pageNo, Integer pageSize);

}
