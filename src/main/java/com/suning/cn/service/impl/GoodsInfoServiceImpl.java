package com.suning.cn.service.impl;

import com.suning.cn.dto.*;
import com.suning.cn.mapper.*;
import com.suning.cn.service.GoodsInfoService;
import com.suning.cn.vo.GoodsInfoVo;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

import static com.suning.cn.cons.HomeNameSpace.MAIN;
import static com.suning.cn.cons.HomeNameSpace.NOT_MAIN;

/**
 * @author tangchaochao
 * @create 2020-2020-09-23 09:02
 */
@Log4j
@Service
public class GoodsInfoServiceImpl extends BaseServiceImpl implements GoodsInfoService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private ReviewsMapper reviewsMapper;
    @Autowired
    private UsersMapper usersMapper;

    /**
     * 展示商品详细信息
     *
     * @param goodsId 商品id
     * @return getGoodsAllInfo
     */
    @Override
    public GoodsInfoVo getGoodsAllInfo(String goodsId) {

        //获取商品信息
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        GoodsInfoVo goodsInfoVo = new GoodsInfoVo();
        BeanUtils.copyProperties(goods, goodsInfoVo);

        //获取主图
        List<String> thumbImg = getImg(goodsId, MAIN);
        goodsInfoVo.setThumbImg(thumbImg.get(0));

        //获取副图
        List<String> sideImg = getImg(goodsId, NOT_MAIN);
        String sideImgStr = String.join(";", sideImg);
        goodsInfoVo.setSideImg(sideImgStr);

        //获取店铺名
        String shopName = shopName(goodsId);
        goodsInfoVo.setShopsName(shopName);

        //获取评论
        Reviews reviews = reviewsMapper.selectByGoodsId(goodsId);
        if (ObjectUtils.isEmpty(reviews)) {
           return  goodsInfoVo;
        }
        BeanUtils.copyProperties(reviews, goodsInfoVo);

        //获取用户名
        Users users = usersMapper.selectByPrimaryKey(reviews.getUserId());
        goodsInfoVo.setNickName(users.getNickName());

        //获取评价总数
        int reviewsCount = reviewsCount(goodsId);
        goodsInfoVo.setAssessCount(reviewsCount);

        return goodsInfoVo;
    }


}
