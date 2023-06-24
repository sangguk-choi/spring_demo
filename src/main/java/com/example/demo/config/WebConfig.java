package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    public static final String ALLOWED_METHOD_NAMES = "GET,HEAD,POST,PUT,DELETE,TRACE,OPTIONS,PATCH";

    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**") // 해당 설정을 적용할 API 범위 선택
                .allowedMethods(ALLOWED_METHOD_NAMES.split(",")) // 허용할 HTTP 메서드 선택 
                .allowedOrigins("*"); // Origin을 허용할 범위 선택
    }
}
