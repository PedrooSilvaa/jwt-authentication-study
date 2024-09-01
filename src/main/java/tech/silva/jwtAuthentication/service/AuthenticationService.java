package tech.silva.jwtAuthentication.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.silva.jwtAuthentication.entity.User;
import tech.silva.jwtAuthentication.repository.UserRepository;
import tech.silva.jwtAuthentication.web.dto.UserLoginDto;

import javax.security.auth.login.CredentialException;

@Service
public class AuthenticationService {
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(JwtService jwtService, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String authenticate(UserLoginDto loginDto) {
        User user = userRepository.findByUsername(loginDto.username())
                .orElseThrow(
                        () -> new UsernameNotFoundException("User not found")
                );
        if (!passwordEncoder.matches(loginDto.password(), user.getPassword())){
            throw new RuntimeException("Invalid password");
        }
        return jwtService.generateToken(user);
    }
}