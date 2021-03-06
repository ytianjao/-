package com.yang.ccks2.model;

import java.io.Serializable;

public class TextCount implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column text_count.id
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column text_count.name
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column text_count.value
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    private Integer value;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table text_count
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column text_count.id
     *
     * @return the value of text_count.id
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column text_count.id
     *
     * @param id the value for text_count.id
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column text_count.name
     *
     * @return the value of text_count.name
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column text_count.name
     *
     * @param name the value for text_count.name
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column text_count.value
     *
     * @return the value of text_count.value
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    public Integer getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column text_count.value
     *
     * @param value the value for text_count.value
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_count
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
        sb.append(", name=").append(name);
        sb.append(", value=").append(value);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}