package com.pieropan.cursospringsecurity.security.config;

import com.pieropan.cursospringsecurity.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().
                httpBasic().
                and().
                authorizeHttpRequests().
                anyRequest().
                authenticated();
    }

    // http basic: para informar o tipo de autentificação
    // csrf().disable(): não é necessário uma vez que estamos implementando nossa autentificação.
    // Se não desabilitar, ações do tipo POST, DELETE, PUT, PATCH não funcionarão
    // authorizeHttpRequests(). anyRequest().permitAll(): Comando que permite todos os endpoints
    // authorizeHttpRequests(). anyRequest().authenticated(): Comando exige autentificação para todos endpoints

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    // com a implementação do AuthenticationManagerBuilder, o user e a senha (gerada ao subir a aplicacao)
    // já não ocorre mais. Login permitido apenas para pieropan senha 123

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // é necessário passar um PasswordEncoder para o inMemoryAuthentication funcionar!!!
}