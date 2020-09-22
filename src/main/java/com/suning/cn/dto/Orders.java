package com.suning.cn.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Orders {
    /**
     * Database Column Remarks:
     *   订单id编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.order_id
     *
     * @mbg.generated
     */
    private String orderId;

    /**
     * Database Column Remarks:
     *   商品id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.shop_id
     *
     * @mbg.generated
     */
    private String shopId;

    /**
     * Database Column Remarks:
     *   用户id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.user_id
     *
     * @mbg.generated
     */
    private String userId;

    /**
     * Database Column Remarks:
     *   商品数量
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.count
     *
     * @mbg.generated
     */
    private Integer count;

    /**
     * Database Column Remarks:
     *   总金额
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.total_cost
     *
     * @mbg.generated
     */
    private Double totalCost;

    /**
     * Database Column Remarks:
     *   优惠金额
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.off_cost
     *
     * @mbg.generated
     */
    private Double offCost;

    /**
     * Database Column Remarks:
     *   实付金额
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.real_pay
     *
     * @mbg.generated
     */
    private Double realPay;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * Database Column Remarks:
     *   修改时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.modify_time
     *
     * @mbg.generated
     */
    private Date modifyTime;


}