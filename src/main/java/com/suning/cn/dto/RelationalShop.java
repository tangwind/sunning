package com.suning.cn.dto;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table relational_shop
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class RelationalShop {
    /**
     * Database Column Remarks:
     *   商品id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column relational_shop.goods_id
     *
     * @mbg.generated
     */
    private String goodsId;

    /**
     * Database Column Remarks:
     *   店铺id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column relational_shop.shop_id
     *
     * @mbg.generated
     */
    private String shopId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column relational_shop.goods_id
     *
     * @return the value of relational_shop.goods_id
     *
     * @mbg.generated
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column relational_shop.goods_id
     *
     * @param goodsId the value for relational_shop.goods_id
     *
     * @mbg.generated
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column relational_shop.shop_id
     *
     * @return the value of relational_shop.shop_id
     *
     * @mbg.generated
     */
    public String getShopId() {
        return shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column relational_shop.shop_id
     *
     * @param shopId the value for relational_shop.shop_id
     *
     * @mbg.generated
     */
    public void setShopId(String shopId) {
        this.shopId = shopId;
    }
}