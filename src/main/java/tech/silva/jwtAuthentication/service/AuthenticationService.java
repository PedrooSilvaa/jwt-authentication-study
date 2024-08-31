package tech.silva.jwtAuthentication.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final JwtService service;

    public AuthenticationService(JwtService service) {
        this.service = service;
    }

    public String authenticate(Authentication authentication){
        return service.generateToken(authentication);
    }

}
