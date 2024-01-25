//package com.projectx.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
///**
// * @author vuktopalovic
// * @created 23/01/2024 - 17:50
// * @project projectx
// */
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
////    @Autowired
////    private JwtAuthenticationFilter jwtAuthenticationFilter;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> apiSecurityConfigurer() {
//        return new SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {
//            @Override
//            public void configure(HttpSecurity http) throws Exception {
//                http
//                        .csrf().disable()
//                        .authorizeRequests()
//                        .antMatchers("/api/register").permitAll()
//                        .anyRequest().authenticated()
//                        .and()
//                        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//            }
//        };
//    }
//}
//
