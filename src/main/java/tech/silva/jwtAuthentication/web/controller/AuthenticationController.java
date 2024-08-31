package tech.silva.jwtAuthentication.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.silva.jwtAuthentication.service.AuthenticationService;

@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("autheticate")
    public String authenticate(Authentication authentication){
        return authenticationService.authenticate(authentication);
    }
}
