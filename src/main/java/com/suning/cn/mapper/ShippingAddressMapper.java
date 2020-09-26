package com.suning.cn.mapper;

import com.suning.cn.dto.ShippingAddress;
import com.suning.cn.dto.ShippingAddressExample;
import java.util.List;

import com.suning.cn.dto.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingAddressMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shipping_address
     *
     * @mbg.generated
     */
    long countByExample(ShippingAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shipping_address
     *
     * @mbg.generated
     */
    int deleteByExample(ShippingAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shipping_address
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shipping_address
     *
     * @mbg.generated
     */
    int insert(ShippingAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shipping_address
     *
     * @mbg.generated
     */
    int insertSelective(ShippingAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shipping_address
     *
     * @mbg.generated
     */
    List<ShippingAddress> selectByExample(ShippingAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shipping_address
     *
     * @mbg.generated
     */
    ShippingAddress selectByPrimaryKey(String userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shipping_address
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ShippingAddress record, @Param("example") ShippingAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shipping_address
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ShippingAddress record, @Param("example") ShippingAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shipping_address
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ShippingAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shipping_address
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ShippingAddress record);

    List<ShippingAddress> selectAddress(@Param("userId") String userId);
}