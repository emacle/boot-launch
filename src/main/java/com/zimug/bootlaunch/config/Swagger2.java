package com.zimug.bootlaunch.config;

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

// 1. 添加 pom.xml 依赖
// 2. 编写本配置包
// 3. 重启 http://localhost:8888/swagger-ui.html

@Configuration
@EnableSwagger2

public class Swagger2 {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 自行修改为自己的包路径
                .apis(RequestHandlerSelectors.basePackage("com.zimug.bootlaunch"))
//                .paths(PathSelectors.any())
                .paths(PathSelectors.regex("/rest/.*")) // 只公开 /rest/ 下的接口
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot swagger构建api文档")
                .description("restfun 风格接口")
                //服务条款网址
                .termsOfServiceUrl("https://emacle.github.io")
                .version("1.0")
                .contact(new Contact("帅呆了", "https://emacle.github.io", "79464972@qq.com"))
                .build();
    }
}
