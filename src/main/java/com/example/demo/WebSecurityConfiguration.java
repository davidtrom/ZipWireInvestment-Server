package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


//@Configuration
//public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers(HttpMethod.POST,"/transactions").permitAll()
//                .antMatchers(HttpMethod.GET,"/transactions").permitAll()
//                .antMatchers(HttpMethod.POST, "/login").permitAll()
//                .antMatchers(HttpMethod.POST,"/newuser/*").permitAll()
//                .antMatchers(HttpMethod.GET,"/master/*").permitAll()
//                .antMatchers(HttpMethod.GET,"/exploreCourse").permitAll()
//                .antMatchers(HttpMethod.POST, "/goal").permitAll()
//                .antMatchers(HttpMethod.GET,"/goal/").permitAll()
//                .antMatchers(HttpMethod.POST, "/goal/*").permitAll()
//                .antMatchers(HttpMethod.GET,"/goal/*").permitAll()
//                .antMatchers(HttpMethod.GET,"/goals/").permitAll()
//                .antMatchers(HttpMethod.GET,"/tracker/*").permitAll()
//                .anyRequest().authenticated();
//    }
//}