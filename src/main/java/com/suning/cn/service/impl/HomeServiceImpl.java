package com.suning.cn.service.impl;

import com.suning.cn.dto.*;
import com.suning.cn.mapper.*;
import com.suning.cn.service.HomeService;
import com.suning.cn.utils.PageUtils;
import com.suning.cn.vo.HomeGoodsVo;
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
public class HomeServiceImpl extends BaseServiceImpl implements HomeService {

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 获取精选商品
     */
    @Override
    public PageUtils<HomeGoodsVo> getChosenGoods(Integer pageNo, Integer pageSize, String type) {

        if (StringUtils.isEmpty(type)) {
            type = DEFAULT_TYPE;
        }

        PageUtils<HomeGoodsVo> pageUtils = new PageUtils<HomeGoodsVo>();
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
        pageUtils.setPageSize(pageSize);
        goodsExample.setLimit(pageUtils.getPageNo());
        goodsExample.setOffset(pageSize);
        goodsExample.setOrderByClause(CAUSE + " DESC");
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        List<HomeGoodsVo> homeGoodsVoList = new ArrayList<>();
        for (Goods goods:goodsList){
            HomeGoodsVo homeGoodsVo = new HomeGoodsVo();
            homeGoodsVo.setGoodsName(goods.getGoodsName());
            homeGoodsVo.setInitPrice(goods.getInitPrice());
            homeGoodsVo.setGoodsId(goods.getGoodsId());

            //主图
            List<String> thumbImg = getImg(goods.getGoodsId(), MAIN);
            homeGoodsVo.setThumbImg(thumbImg.get(GET_MAIN));

            //评论总数
            int count = reviewsCount(goods.getGoodsId());
            homeGoodsVo.setTotalReviews(count);

            //店铺名
            String shopName = shopName(goods.getGoodsId());
            homeGoodsVo.setShopName(shopName);

            homeGoodsVoList.add(homeGoodsVo);
        };

        pageUtils.setCurrentList(homeGoodsVoList);
        return pageUtils;
    }


}
