//package com.FileCloud.FileCloud.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class WebSecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .dispatcherTypeMatchers("/files/uploadfile").permitAll()  // Allow unauthenticated access to upload endpoint
//                        .anyRequest().authenticated()  // Require authentication for other requests
//                )
//                .httpBasic();  // Example: Configuring HTTP Basic authentication
//
//        // If CSRF is not needed (e.g., when using tokens or API calls from Postman)
//        http.csrf().disable();
//
//        return http.build();
//    }
//}
