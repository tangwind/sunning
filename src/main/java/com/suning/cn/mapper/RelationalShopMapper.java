package com.suning.cn.mapper;

import com.suning.cn.dto.RelationalShop;
import com.suning.cn.dto.RelationalShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RelationalShopMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relational_shop
     *
     * @mbg.generated
     */
    long countByExample(RelationalShopExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relational_shop
     *
     * @mbg.generated
     */
    int deleteByExample(RelationalShopExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relational_shop
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String goodsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relational_shop
     *
     * @mbg.generated
     */
    int insert(RelationalShop record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relational_shop
     *
     * @mbg.generated
     */
    int insertSelective(RelationalShop record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relational_shop
     *
     * @mbg.generated
     */
    List<RelationalShop> selectByExample(RelationalShopExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relational_shop
     *
     * @mbg.generated
     */
    RelationalShop selectByPrimaryKey(String goodsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relational_shop
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") RelationalShop record, @Param("example") RelationalShopExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relational_shop
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") RelationalShop record, @Param("example") RelationalShopExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relational_shop
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(RelationalShop record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relational_shop
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(RelationalShop record);
}