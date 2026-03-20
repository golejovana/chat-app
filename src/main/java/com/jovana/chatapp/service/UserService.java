package com.jovana.chatapp.service;

import com.jovana.chatapp.dto.UserResponseDto;
import com.jovana.chatapp.entity.User;
import com.jovana.chatapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public UserResponseDto createUser(User user) {
        User savedUser = userRepository.save(user);
        return toDto(savedUser);
    }

    private UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );
    }
}