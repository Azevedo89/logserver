package com.pst.asseco.logserver.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pst.asseco.logserver.model.LoginRequest;
import com.pst.asseco.logserver.service.AuthService;

import jakarta.annotation.security.PermitAll;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/auth/login")
    @PermitAll
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        boolean isAuthenticated = authService.authenticate(request.getEmail(), request.getPassword());
        if (isAuthenticated) {
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("success", true);
            responseData.put("message", "Login successful");
            return ResponseEntity.ok(responseData);
        } else {
            Map<String, Object> errorData = new HashMap<>();
            errorData.put("success", false);
            errorData.put("message", "Invalid email or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorData);
        }
    }
}
