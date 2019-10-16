package com.unicorn.recruit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdUtil;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/15 16:36
 */
@SpringBootApplication
public class RecruitApplication {
    public static void main(String[] args) {
        SpringApplication.run(RecruitApplication.class,args);
    }
    @Bean
    public IdUtil idWorkker(){
        return new IdUtil(1, 1);
    }

}
