package com.jovana.chatapp.controller;

import com.jovana.chatapp.dto.LoginRequestDto;
import com.jovana.chatapp.dto.LoginResponseDto;
import com.jovana.chatapp.dto.RegisterRequestDto;
import com.jovana.chatapp.dto.UserResponseDto;
import com.jovana.chatapp.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody RegisterRequestDto request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto request) {
        return authService.login(request);
    }
}