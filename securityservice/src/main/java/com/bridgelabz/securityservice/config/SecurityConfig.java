package com.bridgelabz.securityservice.config;

import com.bridgelabz.securityservice.filter.JWTFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

        @Configuration
        public class SecurityConfig {
            @Bean
            public SecurityFilterChain securityFilterChain(HttpSecurity http, JWTFilter jwtFilter) throws Exception {

                http
                        .csrf(csrf -> csrf.disable())
                        .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/auth/**").permitAll()
                                .anyRequest().authenticated()
                        )
                        .addFilterBefore(jwtFilter,
                                org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class);

                return http.build();
            }

            @Bean
            public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) {
                return authenticationConfiguration.getAuthenticationManager();
            }

            @Bean
            public BCryptPasswordEncoder bCryptPasswordEncoder() {
                return new BCryptPasswordEncoder();
            }
        }