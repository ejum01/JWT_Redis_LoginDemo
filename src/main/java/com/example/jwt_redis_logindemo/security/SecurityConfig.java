package com.example.jwt_redis_logindemo.security;

import com.example.jwt_redis_logindemo.config.CorsConfig;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private CorsConfig corsConfig;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // jwt security
        http.csrf().disable();
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .formLogin().disable()
//                .httpBasic().disable()
//                .authorizeRequests()
//                .antMatchers("/member/**")
//                .access("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
//                .antMatchers("/manager/**")
//                .access("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
//                .antMatchers("/admin/**")
//                .access("hasRole('ROLE_ADMIN')")
//                .anyRequest().permitAll();

//         security
              http.authorizeRequests()
                        .antMatchers("/user/**").authenticated()
                        .antMatchers("manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
                        .antMatchers("admin/**").access("hasRole('ROLE_ADMIN')")
                        .anyRequest().permitAll()
                        .and();

                http.formLogin()
                .loginPage("/login") // Update the login page URL
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/member/welcome")
                .permitAll();



    }



}
