package com.suning.cn.service.impl;

import com.suning.cn.dto.RelationalShop;
import com.suning.cn.mapper.ImgExchangeMapper;
import com.suning.cn.mapper.RelationalShopMapper;
import com.suning.cn.mapper.ReviewsMapper;
import com.suning.cn.mapper.ShopsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.suning.cn.cons.HomeNameSpace.NO_DATA;

/**
 * @author tangchaochao
 * @create 2020-2020-09-23 11:14
 */
public class BaseServiceImpl {

    @Autowired
    private ImgExchangeMapper imgExchangeMapper;
    @Autowired
    private RelationalShopMapper relationalShopMapper;
    @Autowired
    private ShopsMapper shopsMapper;
    @Autowired
    private ReviewsMapper reviewsMapper;

    /**
     * 获取商品图片
     *
     * @param goodsId 商品id
     * @param isMain  1为主图，0非主图
     * @return 图片
     */
    public List<String> getImg(String goodsId, String isMain) {
        List<String> thumbImg = imgExchangeMapper.selectImgBygoodsIdAndMain(goodsId, isMain);
        if (ObjectUtils.isEmpty(thumbImg)) {
            thumbImg.add(NO_DATA);
        }
        return thumbImg;
    }


    /**
     * 获取评论总数
     *
     * @param goodsId 商品id
     * @return 评论总数
     */
    public int reviewsCount(String goodsId) {
        long count = reviewsMapper.countByGoodsId(goodsId);
        return Integer.parseInt(String.valueOf(count));
    }

    /**
     * 获取店铺名
     *
     * @param goodsId 商品id
     * @return 店铺名
     */
    protected String shopName(String goodsId) {

        RelationalShop relationalShop = relationalShopMapper.selectByPrimaryKey(goodsId);

        if (ObjectUtils.isEmpty(relationalShop)) {
            return NO_DATA;
        }
        String shopName = shopsMapper.selectNameByPrimaryKey(relationalShop.getShopId());
        return shopName;
    }
}
