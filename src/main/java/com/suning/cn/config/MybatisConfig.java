package com.suning.cn.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.kgc.cn.mapper")
public class MybatisConfig {
}
