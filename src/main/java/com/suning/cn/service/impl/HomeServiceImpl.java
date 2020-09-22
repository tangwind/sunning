package com.suning.cn.service.impl;

import com.suning.cn.dto.*;
import com.suning.cn.mapper.*;
import com.suning.cn.service.HomeService;
import com.suning.cn.utils.PageUtils;
import com.suning.cn.vo.home.HomeGoodsVo;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.suning.cn.cons.HomeNameSpace.*;

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
    private ImgExchangeMapper imgExchangeMapper;
    @Autowired
    private ReviewsMapper reviewsMapper;
    @Autowired
    private RelationalShopMapper relationalShopMapper;
    @Autowired
    private ShopsMapper shopsMapper;


    /**
     * 获取精选商品
     */
    @Override
    public PageUtils<HomeGoodsVo> getChosenGoods(Integer pageNo, Integer pageSize, String type) {

        PageUtils pageUtils = new PageUtils();
        pageUtils.setPageNo(pageNo);
        pageUtils.setCurrentPage(pageNo);

        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andTypeIdEqualTo(type);

        return getHomeGoodsVoPageUtils(pageSize, pageUtils, goodsExample);
    }

    /**
     * 搜索商品
     *
     * @param content 搜索内容
     * @return 相同名称的商品
     */
    @Override
    public PageUtils<HomeGoodsVo> searchGoods(String content, Integer pageNo, Integer pageSize) {
        PageUtils pageUtils = new PageUtils();
        pageUtils.setPageNo(pageNo);
        pageUtils.setCurrentPage(pageNo);

        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andGoodsNameLike("%" + content + "%");

        return getHomeGoodsVoPageUtils(pageSize, pageUtils, goodsExample);
    }

    private PageUtils<HomeGoodsVo> getHomeGoodsVoPageUtils(Integer pageSize, PageUtils pageUtils, GoodsExample goodsExample) {
        long goodsTotal = goodsMapper.countByExample(goodsExample);
        pageUtils.setTotalCount(goodsTotal);

        goodsExample.setLimit(pageUtils.getPageNo());
        goodsExample.setOffset(pageSize);
        goodsExample.setOrderByClause(CAUSE + " DESC");
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        List<HomeGoodsVo> homeGoodsVoList = new ArrayList<>();
        goodsList.forEach(goods -> {
            HomeGoodsVo homeGoodsVo = new HomeGoodsVo();
            homeGoodsVo.setGoodsName(goods.getGoodsName());
            homeGoodsVo.setInitPrice(goods.getInitPrice());
            homeGoodsVo.setGoodsId(goods.getGoodsId());

            //主图
            String thumbImg = thumbImg(goods.getGoodsId());
            homeGoodsVo.setThumbImg(thumbImg);

            //评论总数
            int count = reviewsCount(goods.getGoodsId());
            homeGoodsVo.setTotalReviews(count);

            //店铺名
            String shopName = shopName(goods.getGoodsId());
            homeGoodsVo.setShopName(shopName);

            homeGoodsVoList.add(homeGoodsVo);
        });

        pageUtils.setCurrentList(homeGoodsVoList);
        return pageUtils;
    }


    /**
     * 获取主图
     * @param goodsId 商品id
     * @return 主图
     */
    private String thumbImg(String goodsId) {
        String thumbImg = imgExchangeMapper.selectThumbImgBygoodsIdAndMain(goodsId, MAIN);
        return thumbImg;
    }


    /**
     * 获取评论总数
     * @param goodsId 商品id
     * @return 评论总数
     */
    private int reviewsCount(String goodsId) {
        long count =  reviewsMapper.countByGoodsId(goodsId);
        return Integer.parseInt(String.valueOf(count));
    }

    /**
     * 获取店铺名
     * @param goodsId 商品id
     * @return 店铺名
     */
    private String shopName(String goodsId) {
       RelationalShop relationalShop = relationalShopMapper.selectByPrimaryKey(goodsId);
       String shopName = shopsMapper.selectNameByPrimaryKey(relationalShop.getShopId());
       return shopName;
   }




}
