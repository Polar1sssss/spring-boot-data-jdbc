package com.example.demo.config;

import com.example.demo.bean.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

;

/**
 * @author hujtb
 * @create on 2018-10-31-16:43
 */

@Configuration
public class MyRedisConifg {

    @Bean
    public RedisTemplate<Object, Employee> empRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate<Object, Employee>();
        template.setConnectionFactory(redisConnectionFactory);
        //添加Jackson2JsonRedisSerializer序列化器
        Jackson2JsonRedisSerializer<Employee> ser = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
        template.setDefaultSerializer(ser);
        return template;
    }

    /*@Primary //如果存在多个自定义CacheManager，需要指定一个默认的，否则无法取出缓存数据
    @Bean
    public RedisCacheManager empCacheManager(RedisTemplate<Object, Employee> empRedisTemplate){
        RedisCacheManager redisCacheManager = new RedisCacheManager(empRedisTemplate);
        redisCacheManager.setUseSuffix(true);
        return redisCacheManager;
    }*/
}
