package com.unicorn.mongo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/15 11:38
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket petApi() {
        return new Docket(DocumentationType.SWAGGER_2)

                .select()
                .apis(RequestHandlerSelectors.basePackage("com.unicorn")) //指定提供接口所在的基包
                .paths(PathSelectors.ant("/**"))
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * 该套 API 说明，包含作者、简介、版本、host、服务URL
     * @return
     */

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("吐槽大会-微服务 api  说明")
                .contact(new Contact("wss","www.wangkun.xyz","ahkjqutao@163.com"))
                .version("0.1")
             // .termsOfServiceUrl("localhost:8080/demo1/")
                .description("吐槽大会-微服务-标签 ")
                .build();
    }

}
