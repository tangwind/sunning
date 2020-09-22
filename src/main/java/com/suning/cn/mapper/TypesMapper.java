package com.suning.cn.mapper;

import com.suning.cn.dto.Types;
import com.suning.cn.dto.TypesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table types
     *
     * @mbg.generated
     */
    long countByExample(TypesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table types
     *
     * @mbg.generated
     */
    int deleteByExample(TypesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table types
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String typeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table types
     *
     * @mbg.generated
     */
    int insert(Types record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table types
     *
     * @mbg.generated
     */
    int insertSelective(Types record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table types
     *
     * @mbg.generated
     */
    List<Types> selectByExample(TypesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table types
     *
     * @mbg.generated
     */
    Types selectByPrimaryKey(String typeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table types
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Types record, @Param("example") TypesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table types
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Types record, @Param("example") TypesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table types
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Types record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table types
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Types record);
}