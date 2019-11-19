package com.example.unified;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class UnifiedResultApplication implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //设置classpath路径
        registry.addResourceHandler("/**").addResourceLocations("classpath:/swagger/dist/");
    }

    public static void main(String[] args) {
        SpringApplication.run(UnifiedResultApplication.class, args);
        System.out.println("================springboot启动成功=======================");
    }

}
