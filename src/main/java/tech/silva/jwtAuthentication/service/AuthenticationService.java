package tech.silva.jwtAuthentication.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public String authenticate(){
        return "token";
    }

}
