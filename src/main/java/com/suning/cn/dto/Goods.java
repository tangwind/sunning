package com.suning.cn.dto;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table goods
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class Goods {
    /**
     * Database Column Remarks:
     *   商品id 
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.goods_id
     *
     * @mbg.generated
     */
    private String goodsId;

    /**
     * Database Column Remarks:
     *   商品名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.goods_name
     *
     * @mbg.generated
     */
    private String goodsName;

    /**
     * Database Column Remarks:
     *   商品原价
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.init_price
     *
     * @mbg.generated
     */
    private Double initPrice;

    /**
     * Database Column Remarks:
     *   商品促销价
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.off_price
     *
     * @mbg.generated
     */
    private Double offPrice;

    /**
     * Database Column Remarks:
     *   类型的编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.type_id
     *
     * @mbg.generated
     */
    private String typeId;

    /**
     * Database Column Remarks:
     *   商品的创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * Database Column Remarks:
     *   商品的修改时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.modify_time
     *
     * @mbg.generated
     */
    private Date modifyTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.goods_id
     *
     * @return the value of goods.goods_id
     *
     * @mbg.generated
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.goods_id
     *
     * @param goodsId the value for goods.goods_id
     *
     * @mbg.generated
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.goods_name
     *
     * @return the value of goods.goods_name
     *
     * @mbg.generated
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.goods_name
     *
     * @param goodsName the value for goods.goods_name
     *
     * @mbg.generated
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.init_price
     *
     * @return the value of goods.init_price
     *
     * @mbg.generated
     */
    public Double getInitPrice() {
        return initPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.init_price
     *
     * @param initPrice the value for goods.init_price
     *
     * @mbg.generated
     */
    public void setInitPrice(Double initPrice) {
        this.initPrice = initPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.off_price
     *
     * @return the value of goods.off_price
     *
     * @mbg.generated
     */
    public Double getOffPrice() {
        return offPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.off_price
     *
     * @param offPrice the value for goods.off_price
     *
     * @mbg.generated
     */
    public void setOffPrice(Double offPrice) {
        this.offPrice = offPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.type_id
     *
     * @return the value of goods.type_id
     *
     * @mbg.generated
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.type_id
     *
     * @param typeId the value for goods.type_id
     *
     * @mbg.generated
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.create_time
     *
     * @return the value of goods.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.create_time
     *
     * @param createTime the value for goods.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.modify_time
     *
     * @return the value of goods.modify_time
     *
     * @mbg.generated
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.modify_time
     *
     * @param modifyTime the value for goods.modify_time
     *
     * @mbg.generated
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}