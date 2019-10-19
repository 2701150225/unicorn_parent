package com.unicorn.activity;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import util.IdUtil;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/17 18:01
 */


@SpringBootApplication
@EnableCaching
public class ActivityApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActivityApplication.class, args);
    }

    @Bean
    public IdUtil idUtil() {
        return new IdUtil(1, 1);
    }


}
