package tech.silva.jwtAuthentication.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.silva.jwtAuthentication.service.AuthenticationService;
import tech.silva.jwtAuthentication.web.dto.UserLoginDto;

@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody UserLoginDto loginDto){
        return authenticationService.authenticate(loginDto);
    }
}
