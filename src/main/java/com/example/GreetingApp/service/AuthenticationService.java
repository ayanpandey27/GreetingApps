package com.example.GreetingApp.service;

import com.example.GreetingApp.dto.AuthUserDTO;
import com.example.GreetingApp.dto.LoginDTO;
import com.example.GreetingApp.model.AuthUser;
import com.example.GreetingApp.repository.AuthUserRepository;
import com.example.GreetingApp.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthenticationService {
    private final AuthUserRepository authUserRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(AuthUserRepository authUserRepository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.authUserRepository = authUserRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(AuthUserDTO authUserDTO) {
        if (authUserRepository.findByEmail(authUserDTO.getEmail()).isPresent()) {
            return "Email is already in use.";
        }
        AuthUser user = new AuthUser();
        user.setFirstName(authUserDTO.getFirstName());
        user.setLastName(authUserDTO.getLastName());
        user.setEmail(authUserDTO.getEmail());
        user.setPassword(passwordEncoder.encode(authUserDTO.getPassword())); // Encode password
        authUserRepository.save(user);
        return "User registered successfully!";
    }

    //    public String login(LoginDTO loginDTO) {
//        Optional<AuthUser> userOptional = authUserRepository.findByEmail(loginDTO.getEmail());
//        if (userOptional.isEmpty() || !passwordEncoder.matches(loginDTO.getPassword(), userOptional.get().getPassword())) {
//            return "Invalid email or password!";
//        }
//        return jwtUtil.generateToken(userOptional.get().getEmail());
//    }
    public String login(LoginDTO loginDTO) {
        Optional<AuthUser> userOptional = authUserRepository.findByEmail(loginDTO.getEmail());

        if (userOptional.isEmpty()) {
            System.out.println("🚨 DEBUG: User not found in the database.");
            return "User not found!";
        }

        AuthUser user = userOptional.get();
        System.out.println("🔹 DEBUG: Found user with email: " + user.getEmail());
        System.out.println("🔹 DEBUG: Hashed password in DB: " + user.getPassword());

        // Check password
        boolean passwordMatches = passwordEncoder.matches(loginDTO.getPassword(), user.getPassword());
        System.out.println("🔹 DEBUG: Password match result: " + passwordMatches);

        if (!passwordMatches) {
            return "Invalid email or password!";
        }

        return jwtUtil.generateToken(user.getEmail());
    }

}