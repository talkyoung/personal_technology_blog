package com.talkyoung.simpro.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis配置类
 *  on 2019/4/8.
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.talkyoung.simpojo.mapper","com.talkyoung.simpro.dao"})
public class MyBatisConfig {
}
