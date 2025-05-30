package ru.sso_server_real.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class MVCConfiguration implements WebMvcConfigurer {
     @Bean
     public BCryptPasswordEncoder passwordEncoder() {
         BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
         return bCryptPasswordEncoder;
     }
}