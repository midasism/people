package com.people.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.formLogin()//自定义自己的登录页面
            .loginPage("/page/login")//登录页面设置
            .loginProcessingUrl("/user/login")//登录访问路径
            .defaultSuccessUrl("/page/index")
                .permitAll()//登录成功后，跳转路径
            .and().authorizeRequests()
                .antMatchers("/","/page/login","/page/register","/page/404","/page/error").permitAll()//设置可以直接访问的路径，不需要认证
                .and().csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Bean
    PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }

}
