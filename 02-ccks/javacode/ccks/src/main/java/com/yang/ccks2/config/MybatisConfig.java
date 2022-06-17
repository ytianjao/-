package com.yang.ccks2.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.yang.ccks2.mapper")
public class MybatisConfig {
}
