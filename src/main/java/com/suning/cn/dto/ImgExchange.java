package com.suning.cn.dto;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table img_exchange
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class ImgExchange {
    /**
     * Database Column Remarks:
     *   商品的id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column img_exchange.good_id
     *
     * @mbg.generated
     */
    private String goodId;

    /**
     * Database Column Remarks:
     *   图片的id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column img_exchange.pid
     *
     * @mbg.generated
     */
    private String pid;

    /**
     * Database Column Remarks:
     *   是否为主图（0-否/ 1-是）
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column img_exchange.is_main
     *
     * @mbg.generated
     */
    private Integer isMain;

    /**
     * Database Column Remarks:
     *   图片的地址 记得是以 ；作为分割符，第一张为主图
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column img_exchange.pic_url
     *
     * @mbg.generated
     */
    private String picUrl;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column img_exchange.good_id
     *
     * @return the value of img_exchange.good_id
     *
     * @mbg.generated
     */
    public String getGoodId() {
        return goodId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column img_exchange.good_id
     *
     * @param goodId the value for img_exchange.good_id
     *
     * @mbg.generated
     */
    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column img_exchange.pid
     *
     * @return the value of img_exchange.pid
     *
     * @mbg.generated
     */
    public String getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column img_exchange.pid
     *
     * @param pid the value for img_exchange.pid
     *
     * @mbg.generated
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column img_exchange.is_main
     *
     * @return the value of img_exchange.is_main
     *
     * @mbg.generated
     */
    public Integer getIsMain() {
        return isMain;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column img_exchange.is_main
     *
     * @param isMain the value for img_exchange.is_main
     *
     * @mbg.generated
     */
    public void setIsMain(Integer isMain) {
        this.isMain = isMain;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column img_exchange.pic_url
     *
     * @return the value of img_exchange.pic_url
     *
     * @mbg.generated
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column img_exchange.pic_url
     *
     * @param picUrl the value for img_exchange.pic_url
     *
     * @mbg.generated
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}