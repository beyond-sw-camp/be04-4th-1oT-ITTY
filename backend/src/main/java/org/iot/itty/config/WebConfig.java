package org.iot.itty.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

       @Override
       public void addCorsMappings(CorsRegistry corsRegistry) {

           corsRegistry.addMapping("/**")
                   .exposedHeaders("Set-Cookie")
                   .allowedOrigins("*") // 클라이언트 애플리케이션이 실행 중인 정확한 URL로 변경
                   .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 필요한 메소드에 따라 조정
                   .allowCredentials(false); // 필요한 경우 설정
   }
}
