package com.pst.asseco.logserver.service;
 
import org.springframework.stereotype.Service;
 
@Service
public class AuthService {
 
    public boolean authenticate(String email, String password){
        System.out.println("auth cont");
        return email.equals("demo@pst.asseco.com") && password.equals("demo");
    }

    /*public String getUsernameFromToken(String jwt) {
        throw new UnsupportedOperationException("Unimplemented method 'getUsernameFromToken'");
    } */
}