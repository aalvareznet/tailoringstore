package com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.config.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.config.security.jwt.JwtService;
import com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.entity.User;
import com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.entity.enums.Role;
import com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.repository.UserRepo;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepo userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user =  userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.CUSTOMER)
                .build();
        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}