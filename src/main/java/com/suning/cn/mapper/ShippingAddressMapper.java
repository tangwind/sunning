package com.suning.cn.mapper;

import com.suning.cn.dto.ShippingAddress;
import com.suning.cn.dto.ShippingAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
    int deleteByExample(ShippingAddressExample example, @Param("isDel") Integer isDel);

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
    int updateByExampleSelective(@Param("record") ShippingAddress record, @Param("example") ShippingAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shipping_address
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ShippingAddress record, @Param("example") ShippingAddressExample example);

    List<ShippingAddress> selectAddress(String userId);
}