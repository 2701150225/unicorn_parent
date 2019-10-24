package com.unicorn.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdUtil;


/**
 * @Author:wangsusheng
 * @Date: 2019/10/15 11:38
 */

@SpringBootApplication
public class SearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class);
    }

    @Bean
    public IdUtil idUtil(){
        return new IdUtil(1,1);
    }



}
