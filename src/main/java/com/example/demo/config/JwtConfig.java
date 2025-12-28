// package com.example.demo.config;

// import com.example.demo.security.JwtTokenProvider;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class JwtConfig {

//     @Bean
//     public JwtTokenProvider jwtTokenProvider() {

//          String secret =
//                 "THIS_IS_A_PRODUCTION_SECRET_KEY_32_CHARS_MINIMUM";

//         long expirationMs = 1000 * 60 * 60; // 1 hour

//         return new JwtTokenProvider(secret, expirationMs);
//     }
// }
