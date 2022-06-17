package com.yang.ccks2.mapper;

import com.yang.ccks2.model.EntityCount;
import com.yang.ccks2.model.EntityCountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EntityCountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entity_count
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    long countByExample(EntityCountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entity_count
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    int deleteByExample(EntityCountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entity_count
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entity_count
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    int insert(EntityCount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entity_count
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    int insertSelective(EntityCount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entity_count
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    List<EntityCount> selectByExample(EntityCountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entity_count
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    EntityCount selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entity_count
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    int updateByExampleSelective(@Param("record") EntityCount record, @Param("example") EntityCountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entity_count
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    int updateByExample(@Param("record") EntityCount record, @Param("example") EntityCountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entity_count
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    int updateByPrimaryKeySelective(EntityCount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entity_count
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    int updateByPrimaryKey(EntityCount record);
}