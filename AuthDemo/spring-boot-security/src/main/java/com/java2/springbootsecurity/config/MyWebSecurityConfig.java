package com.java2.springbootsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .authorizeRequests()
                .antMatchers("/index.html","/js/**","/","/css/**","/img/**","/login","/a").permitAll()
                .antMatchers("/mobile/**").hasAuthority("mobile")
                .antMatchers("/salary/**").hasAuthority("salary")
                .antMatchers("/common/**").permitAll()
                .anyRequest().authenticated()
                .and()
        .formLogin().defaultSuccessUrl("/main.html").failureForwardUrl("/index.html");
    }
}
