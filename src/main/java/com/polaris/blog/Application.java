package com.polaris.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author polaris
 *
 */
@SpringBootApplication
@MapperScan("com.polaris.blog.mapper")
@EnableTransactionManagement
@EnableCaching
public class Application {
	public static void main(String[] args) { 
		SpringApplication.run(Application.class, args);
	}
}
