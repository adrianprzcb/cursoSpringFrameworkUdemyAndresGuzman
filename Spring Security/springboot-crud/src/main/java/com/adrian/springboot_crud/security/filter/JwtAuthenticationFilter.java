package com.adrian.springboot_crud.security.filter;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

    private AuthenticationManager authenticatorManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticatorManager){
        this.authenticatorManager = authenticatorManager;
    }

}
