package com.suning.cn.dto;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table goods_stock
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class GoodsStock {
    /**
     * Database Column Remarks:
     *   商品id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_stock.goods_id
     *
     * @mbg.generated
     */
    private String goodsId;

    /**
     * Database Column Remarks:
     *   商品库存
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_stock.goods_num
     *
     * @mbg.generated
     */
    private Integer goodsNum;

    /**
     * Database Column Remarks:
     *   商品入库时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_stock.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * Database Column Remarks:
     *   商品数量更改的时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_stock.modify_time
     *
     * @mbg.generated
     */
    private Date modifyTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_stock.goods_id
     *
     * @return the value of goods_stock.goods_id
     *
     * @mbg.generated
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_stock.goods_id
     *
     * @param goodsId the value for goods_stock.goods_id
     *
     * @mbg.generated
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_stock.goods_num
     *
     * @return the value of goods_stock.goods_num
     *
     * @mbg.generated
     */
    public Integer getGoodsNum() {
        return goodsNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_stock.goods_num
     *
     * @param goodsNum the value for goods_stock.goods_num
     *
     * @mbg.generated
     */
    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_stock.create_time
     *
     * @return the value of goods_stock.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_stock.create_time
     *
     * @param createTime the value for goods_stock.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_stock.modify_time
     *
     * @return the value of goods_stock.modify_time
     *
     * @mbg.generated
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_stock.modify_time
     *
     * @param modifyTime the value for goods_stock.modify_time
     *
     * @mbg.generated
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}