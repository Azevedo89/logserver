/* package com.pst.asseco.logserver.SecurityFilters;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.pst.asseco.logserver.service.AuthService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private AuthService authService;

    public JWTAuthenticationFilter(String defaultFilterProcessesUrl, AuthService authService) {
        super(new AntPathRequestMatcher(defaultFilterProcessesUrl));
        this.authService = authService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // Extrair o token JWT do cabeçalho Authorization
        String token = request.getHeader("Authorization");
        
        // Validar o token JWT e extrair informações do usuário
        if (token != null && token.startsWith("Bearer ")) {
            String jwt = token.substring(7); 
            
            // Validar o token e obter as informações do usuário
            String username = validateTokenAndGetUsername(jwt); 
            
            if (username != null) {
                return new UsernamePasswordAuthenticationToken(username, null);
            }
        }
        
        return null;
    }

    private String validateTokenAndGetUsername(String jwt) {
        String username = authService.getUsernameFromToken(jwt);
        return username;    
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(authResult);
        chain.doFilter(request, response);
    }
}

 */