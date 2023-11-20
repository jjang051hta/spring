package com.jjang051.isotope.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    // 여기에 시쿠리티가 적용될 사항들 설정....

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        //람다식으로 작성....
        httpSecurity.authorizeHttpRequests((auth)-> auth
                .requestMatchers("/","/member/**","/css/**","/js/**")
                .permitAll()
                .anyRequest()
                .authenticated())
                .formLogin((auth)-> auth
                        .loginPage("/member/login")
                        .loginProcessingUrl("/member/login")
                        .defaultSuccessUrl("/isotope/main")
                        .permitAll()
                );
        return httpSecurity.build();
    }
}
