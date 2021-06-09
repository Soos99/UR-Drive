package com.springmvc.urdrive.security;

import com.springmvc.urdrive.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@AllArgsConstructor
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private final AuthenticationService authenticationService;

    @Override
    public void configure(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.authenticationProvider(authenticationService);
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        // allow sign up
        httpSecurity.csrf().disable().authorizeRequests()
                .antMatchers("/signup", "/css/**", "/js/**").permitAll()
                .anyRequest().authenticated();
        // allow to access login page
        httpSecurity.formLogin()
                .loginPage("/login")
                .permitAll();
        // redirect to chat when succeed
        httpSecurity.formLogin()
                .defaultSuccessUrl("/", true);
        // allow to logout
        httpSecurity.logout().permitAll();
    }
}

