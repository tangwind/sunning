package com.suning.cn.service.impl;

import com.suning.cn.dto.*;
import com.suning.cn.mapper.*;
import com.suning.cn.service.GoodsInfoService;
import com.suning.cn.utils.PageUtils;
import com.suning.cn.vo.GoodsInfoVo;

import com.suning.cn.vo.ReviewsVo;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

import static com.suning.cn.cons.HomeNameSpace.*;

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
    @Autowired
    private GoodsStockMapper goodsStockMapper;

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
        goodsInfoVo.setThumbImg(thumbImg.get(GET_MAIN));

        //获取副图
        List<String> sideImg = getImg(goodsId, NOT_MAIN);
        String sideImgStr = String.join(";", sideImg);

        goodsInfoVo.setSideImg(sideImgStr);

        //获取店铺名
        String shopName = shopName(goodsId);
        goodsInfoVo.setShopsName(shopName);

        //获取评论
        List<Reviews> reviewsList = reviewsMapper.selectByGoodsId(goodsId, LIMIT);
        if (ObjectUtils.isEmpty(reviewsList)) {
           return  goodsInfoVo;
        }
        Reviews reviews = reviewsList.get(GET_REVIEW);
        reviews.setImages(this.getImgUrl(reviews.getImages()));
        BeanUtils.copyProperties(reviews, goodsInfoVo);

        //获取库存
        int goodsStock = goodsStockMapper.selectNumByPrimaryKey(goodsId);
        if (goodsStock > GOODS_STOCK) {
            goodsStock = GOODS_STOCK;
        }
        goodsInfoVo.setStock(goodsStock);

        //获取用户名
        Users users = usersMapper.selectByPrimaryKey(reviews.getUserId());
        goodsInfoVo.setNickName(users.getNickName());

        //获取评价总数
        int reviewsCount = reviewsCount(goodsId);
        goodsInfoVo.setAssessCount(reviewsCount);

        return goodsInfoVo;
    }

    /**
     * 获取评价列表
     * @param goodsId 商品
     * @return 评价列表
     */
    @Override
    public PageUtils<ReviewsVo> getReviewsList(String goodsId, Integer pageNo, Integer pageSize) {
        PageUtils pageUtils = new PageUtils();
        pageUtils.setPageNo(pageNo);
        pageUtils.setCurrentPage(pageNo);
        pageUtils.setPageSize(pageSize);
        long reviewsCount = reviewsMapper.countByGoodsId(goodsId);
        pageUtils.setTotalCount(Integer.parseInt(String.valueOf(reviewsCount)));
        ReviewsExample reviewsExample = new ReviewsExample();
        reviewsExample.createCriteria().andGoodsIdEqualTo(goodsId);
        reviewsExample.setLimit(pageNo);
        reviewsExample.setOffset(pageSize);
        reviewsExample.setOrderByClause(REVIEW_BY + " DESC");
        List<Reviews> reviewsList = reviewsMapper.selectByExample(reviewsExample);
        List<ReviewsVo> reviewsVos = new ArrayList<>();
        reviewsList.forEach(reviews -> {
            ReviewsVo reviewsVo = new ReviewsVo();
            reviews.setImages(this.getImgUrl(reviews.getImages()));
            BeanUtils.copyProperties(reviews, reviewsVo);
            reviewsVos.add(reviewsVo);
        });
        pageUtils.setCurrentList(reviewsVos);
        return pageUtils;
    }

    private String getImgUrl(String fileName){
        String imgUrl = "http://47.116.79.240:6666/usr/local/project/img/";
        imgUrl += fileName;
        return imgUrl;
    }

}
