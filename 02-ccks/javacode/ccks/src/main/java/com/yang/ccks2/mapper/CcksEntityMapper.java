package com.yang.ccks2.mapper;

import com.yang.ccks2.model.CcksEntity;
import com.yang.ccks2.model.CcksEntityExample;
import java.util.List;

import com.yang.ccks2.model.CountResultMap;
import org.apache.ibatis.annotations.Param;

public interface CcksEntityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    long countByExample(CcksEntityExample example);
    List<CountResultMap> countAllEntityByEntityName();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    int deleteByExample(CcksEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    int deleteByPrimaryKey(Long entityId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    int insert(CcksEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    int insertSelective(CcksEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    List<CcksEntity> selectByExample(CcksEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    CcksEntity selectByPrimaryKey(Long entityId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    int updateByExampleSelective(@Param("record") CcksEntity record, @Param("example") CcksEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    int updateByExample(@Param("record") CcksEntity record, @Param("example") CcksEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    int updateByPrimaryKeySelective(CcksEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    int updateByPrimaryKey(CcksEntity record);
}
