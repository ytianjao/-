package com.yang.ccks2.model;

import java.io.Serializable;

public class EntityCount implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column entity_count.id
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column entity_count.text_name
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    private String textName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column entity_count.entity_name
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    private String entityName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column entity_count.value
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    private Integer value;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table entity_count
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column entity_count.id
     *
     * @return the value of entity_count.id
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column entity_count.id
     *
     * @param id the value for entity_count.id
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column entity_count.text_name
     *
     * @return the value of entity_count.text_name
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    public String getTextName() {
        return textName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column entity_count.text_name
     *
     * @param textName the value for entity_count.text_name
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    public void setTextName(String textName) {
        this.textName = textName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column entity_count.entity_name
     *
     * @return the value of entity_count.entity_name
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    public String getEntityName() {
        return entityName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column entity_count.entity_name
     *
     * @param entityName the value for entity_count.entity_name
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column entity_count.value
     *
     * @return the value of entity_count.value
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    public Integer getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column entity_count.value
     *
     * @param value the value for entity_count.value
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entity_count
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", textName=").append(textName);
        sb.append(", entityName=").append(entityName);
        sb.append(", value=").append(value);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}