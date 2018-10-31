package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 引入Redis缓存：
 * 		原理：CacheManager === Cache 缓存组件来实际给缓存中存数据
 * 		1、引入redis的starter，容器中自动加载的是RedisCacheManager
 * 		2、RedisCacheManager帮我们创建RedisCache作为缓存组件，RedisCache通过操作redis缓存数据
 * 		3、默认保存数据k-v都是Object；利用序列化保存；如何保存为json呢?
 * 			1)、引入redis的starter，CacheManager变为RedisCacheManager
 * 			2)、默认创建RedisCacheManager，使用的是RedisTemplate<Object,Object>
 * 			3)、RedisTemplate<Object,Object>默认使用的是jdk序列化机制
 * 		4、自定义CacheManager
 */
@MapperScan(basePackages = {"com.example.demo.mapper"})
@SpringBootApplication
@EnableCaching //一定要在主程序类上写这个，之前没写，死活缓存不了，真是醉了
public class SpringBootDataJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJdbcApplication.class, args);
	}
}
