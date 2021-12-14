package com.yltrcc.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yltrcc.blog.config.thymeleaf.dialect.ThSysDialect;

/**
 * Thymeleaf配置
 * 
 * @author yltrcc
 * @createDate : 2018年12月4日
 *
 */
@Configuration
public class ThymeleafDialectConfig {
	@Bean
	public ThSysDialect thSysDialect() {
		return new ThSysDialect();
	}
}
