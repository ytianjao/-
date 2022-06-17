package com.yang.ccks2.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;


public class CountResultMap implements Serializable {
//    private Long id;

    @Override
    public String toString() {
        return "CountResultMap{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    private static final long serialVersionUID = 1L;

    private String name;
    private Integer value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
