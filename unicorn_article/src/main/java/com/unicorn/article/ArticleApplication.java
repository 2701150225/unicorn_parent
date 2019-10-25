package com.unicorn.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import util.IdUtil;
import util.JwtUtil;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/16 13:39
 */
@SpringBootApplication
@EnableCaching
@EnableEurekaClient
public class ArticleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class, args);
    }

    @Bean
    public IdUtil idUtil() {
        return new IdUtil(1, 1);
    }


    //配置redis,防止中文乱码
    @Configuration
    public class RedisConfigurtion {
        @Autowired
        private RedisTemplate redisTemplate;

        @Bean(name = "redisTemplate")
        public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
            RedisTemplate<String, String> template = new RedisTemplate<>();
            template.setConnectionFactory(factory);
            template.setKeySerializer(new StringRedisSerializer());
            template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
            template.setHashKeySerializer(new GenericJackson2JsonRedisSerializer());
            template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
            template.afterPropertiesSet();
            return template;
        }
    }

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil();
    }

}
