package com.kaique.music.configuration;

import com.kaique.music.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    MyUserDetailService myUserDetailService;
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity httpSec) throws Exception {
        return httpSec.
            csrf(AbstractHttpConfigurer::disable).
            authorizeHttpRequests(registry->{
                registry.requestMatchers("/public","/register/**").permitAll();
                registry.requestMatchers("/user/**", "/playlist/**", "/music/**,/author/**").hasRole("user");
                registry.anyRequest().authenticated();
            }
        ).
        formLogin(AbstractAuthenticationFilterConfigurer::permitAll).
        build();
    }
    @Bean
    public UserDetailsService userDetailsService() {
        return myUserDetailService;
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}