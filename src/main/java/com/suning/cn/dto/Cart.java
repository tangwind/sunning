package com.suning.cn.dto;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table cart
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class Cart {
    /**
     * Database Column Remarks:
     *   用户id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cart.user_id
     *
     * @mbg.generated
     */
    private String userId;

    /**
     * Database Column Remarks:
     *   商品id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cart.goods_id
     *
     * @mbg.generated
     */
    private String goodsId;

    /**
     * Database Column Remarks:
     *   商品数量
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cart.goods_num
     *
     * @mbg.generated
     */
    private Integer goodsNum;

    /**
     * Database Column Remarks:
     *   0:原价/1:打折价
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cart.price_type
     *
     * @mbg.generated
     */
    private Integer priceType;

    /**
     * Database Column Remarks:
     *   商品单价
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cart.cart_price
     *
     * @mbg.generated
     */
    private Double cartPrice;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cart.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * Database Column Remarks:
     *   是否删除 （0-删除/1-存在）
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cart.is_del
     *
     * @mbg.generated
     */
    private Integer isDel;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cart.user_id
     *
     * @return the value of cart.user_id
     *
     * @mbg.generated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cart.user_id
     *
     * @param userId the value for cart.user_id
     *
     * @mbg.generated
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cart.goods_id
     *
     * @return the value of cart.goods_id
     *
     * @mbg.generated
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cart.goods_id
     *
     * @param goodsId the value for cart.goods_id
     *
     * @mbg.generated
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cart.goods_num
     *
     * @return the value of cart.goods_num
     *
     * @mbg.generated
     */
    public Integer getGoodsNum() {
        return goodsNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cart.goods_num
     *
     * @param goodsNum the value for cart.goods_num
     *
     * @mbg.generated
     */
    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cart.price_type
     *
     * @return the value of cart.price_type
     *
     * @mbg.generated
     */
    public Integer getPriceType() {
        return priceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cart.price_type
     *
     * @param priceType the value for cart.price_type
     *
     * @mbg.generated
     */
    public void setPriceType(Integer priceType) {
        this.priceType = priceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cart.cart_price
     *
     * @return the value of cart.cart_price
     *
     * @mbg.generated
     */
    public Double getCartPrice() {
        return cartPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cart.cart_price
     *
     * @param cartPrice the value for cart.cart_price
     *
     * @mbg.generated
     */
    public void setCartPrice(Double cartPrice) {
        this.cartPrice = cartPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cart.create_time
     *
     * @return the value of cart.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cart.create_time
     *
     * @param createTime the value for cart.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cart.is_del
     *
     * @return the value of cart.is_del
     *
     * @mbg.generated
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cart.is_del
     *
     * @param isDel the value for cart.is_del
     *
     * @mbg.generated
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}