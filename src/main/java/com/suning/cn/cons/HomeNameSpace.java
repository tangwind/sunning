package com.suning.cn.cons;

import org.springframework.stereotype.Component;

/**
 * @author tangchaochao
 * @create 2020-2020-09-22 12:13
 */

@Component
public class HomeNameSpace {


    /**
     * 查询时排序的依据
     */
    public static final String CAUSE = "goods_name";

    /**
     * 查询主图条件
     */
    public static final String MAIN = "1";

    /**
     * 查询非主图条件
     */
    public static final String NOT_MAIN = "0";

    /**
     * 集合获取主图
     */
    public static final int GET_MAIN = 0;

    /**
     * 集合获取一条评论
     */
    public static final int GET_REVIEW = 0;

    /**
     * 数据库获取一条评论
     */
    public static final int LIMIT = 1;

    /**
     * 默认类型
     */
    public static final String DEFAULT_TYPE = "10001";

    /**
     * 查询评论的排序
     */
    public static final String REVIEW_BY = "score";

    /**
     * 删除购物车
     */
    public static final Integer CART_DEL = 0;

    /**
     * 购物车商品数量大于库存
     */
    public static final String CART_NUM = "1";

    /**
     * 购物车商品数量修改成功
     */
    public static final String CART_SUCCESS = "修改成功！";

    /**
     * 购物车商品数量修改错误
     */
    public static final String CART_FAIL = "修改失败！";

    /**
     * 购物车商品数量最大数量
     */
    public static final Integer MAX_NUM = 99;

    /**
     * 单次购买商品的最大件数
     */
    public static final Integer GOODS_STOCK = 99;

    /**
     * 没有数据
     */
    public static final String NO_DATA = "没有数据！";


}
