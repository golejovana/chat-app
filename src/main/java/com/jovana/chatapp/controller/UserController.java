package com.jovana.chatapp.controller;

import com.jovana.chatapp.dto.UserResponseDto;
import com.jovana.chatapp.entity.User;
import com.jovana.chatapp.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public UserResponseDto createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}