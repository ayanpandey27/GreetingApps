package com.example.GreetingApp.controller;

import com.example.GreetingApp.dto.AuthUserDTO;
import com.example.GreetingApp.dto.LoginDTO;
import com.example.GreetingApp.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody AuthUserDTO authUserDTO) {
        return ResponseEntity.ok(authenticationService.register(authUserDTO)); // FIXED method name
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@Valid @RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(authenticationService.login(loginDTO)); // FIXED method name
    }
}