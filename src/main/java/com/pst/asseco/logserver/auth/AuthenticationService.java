package com.pst.asseco.logserver.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pst.asseco.logserver.config.JwtService;
import com.pst.asseco.logserver.model.Role;
import com.pst.asseco.logserver.model.User; // Importa a classe User correta
import com.pst.asseco.logserver.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        // Constrói o objeto User corretamente
        var user = User.builder()
            .firstname(request.getFirstname())
            .lastname(request.getLastname())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(Role.USER)
            .build();
    
        // Salva o usuário no repositório
        repository.save(user);

        // Converte o objeto User para UserDetails
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
            user.getEmail(),
            user.getPassword(),
            user.getAuthorities()
        );

        // Gera o token JWT usando o UserDetails
        var jwtToken = jwtService.generateToken(userDetails);
        
        // Retorna a resposta de autenticação com o token JWT
        return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        // Autentica o usuário usando o AuthenticationManager
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(), 
                request.getPassword())
        );

        // Busca o usuário no repositório pelo email
        var user = repository.findByEmail(request.getEmail())
            .orElseThrow();

        // Converte o objeto User para UserDetails
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
            user.getEmail(),
            user.getPassword(),
            user.getAuthorities()
        );

        // Gera o token JWT usando o UserDetails
        var jwtToken = jwtService.generateToken(userDetails);
        
        // Retorna a resposta de autenticação com o token JWT
        return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();
    }
}
