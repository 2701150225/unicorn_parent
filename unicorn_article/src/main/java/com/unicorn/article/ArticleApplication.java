package com.unicorn.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdUtil;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/16 13:39
 */
@SpringBootApplication
public class ArticleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class, args);
    }

    @Bean
    public IdUtil idUtil(){
        return new IdUtil(1, 1);
    }

}
