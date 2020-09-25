package com.suning.cn.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
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

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig {

    // 配置Bean实例
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.suning.cn.controller"))// 提供接口所在的基包
                .paths(PathSelectors.any())
                .build();
    }
    // 配置Swagger的Api信息
    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("API接口文档")
                .contact(new Contact("KH83-1组","null","1711424366@qq.com"))
                .description("前后端分离项目做--苏宁易购小程序")
                .termsOfServiceUrl("http://47.116.79.240:8080/")
                .version("1.0")
                .build();
    }
}
