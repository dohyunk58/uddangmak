package com.uddangmak.smartfan.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // CORS 적용 API 경로
                .allowedOrigins("http://localhost:5173", "http://127.0.0.1:5173") // React 개발 서버 주소
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용 HTTP 메서드
                .allowedHeaders("*") // 허용 요청 헤더
                .allowCredentials(true) // 자격 증명(쿠키, HTTP 인증) 허용
                .maxAge(3600); // Pre-flight 요청 결과 캐시 시간
    }
}