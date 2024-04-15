/* package com.pst.asseco.logserver.config;

import com.pst.asseco.logserver.SecurityFilters.JWTAuthenticationFilter;
import com.pst.asseco.logserver.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter{

    @Autowired
    private AuthService authService;

    @Bean
    public void configure(HttpSecurity http) throws Exception{
        http    
            .csrf().disable()
            .exceptionHandling()
            .and()
            .authorizeRequests()
                .antMatchers("/securityNone").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .anyRequest().authenticated()
            .and()
            .addFilterBefore(new JWTAuthenticationFilter("/login", authService),
                UsernamePasswordAuthenticationFilter.class);
    }

}
 */