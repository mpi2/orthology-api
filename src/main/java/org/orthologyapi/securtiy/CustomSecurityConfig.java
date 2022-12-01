package org.orthologyapi.securtiy;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class CustomSecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeHttpRequests()
            .requestMatchers(HttpMethod.GET, "/api/ortholog/**")
            .permitAll()
            .requestMatchers(HttpMethod.GET, "/docs.html").permitAll();


        http.headers().frameOptions().disable();
        return http.build();
    }

}


