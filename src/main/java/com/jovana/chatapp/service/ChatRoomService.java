package com.jovana.chatapp.service;

import com.jovana.chatapp.entity.ChatRoom;
import com.jovana.chatapp.entity.User;
import com.jovana.chatapp.repository.ChatRoomRepository;
import com.jovana.chatapp.repository.UserRepository;
import com.jovana.chatapp.dto.ChatRoomResponseDto;
import com.jovana.chatapp.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final UserRepository userRepository;

    public ChatRoomResponseDto createRoom(String name, String description, boolean isPrivate, String email) {
        User owner = userRepository.findByEmail(email)
                .orElseThrow();

        ChatRoom room = ChatRoom.builder()
                .name(name)
                .description(description)
                .isPrivate(isPrivate)
                .owner(owner)
                .build();

        room.getMembers().add(owner);

        ChatRoom savedRoom = chatRoomRepository.save(room);
        return toDto(savedRoom);
    }

    public List<ChatRoomResponseDto> getAllPublicRooms() {
        return chatRoomRepository.findAll()
                .stream()
                .filter(r -> !r.isPrivate())
                .map(this::toDto)
                .toList();
    }

    private ChatRoomResponseDto toDto(ChatRoom room) {
        UserResponseDto ownerDto = new UserResponseDto(
                room.getOwner().getId(),
                room.getOwner().getUsername(),
                room.getOwner().getEmail()
        );

        List<UserResponseDto> memberDtos = room.getMembers()
                .stream()
                .map(user -> new UserResponseDto(
                        user.getId(),
                        user.getUsername(),
                        user.getEmail()
                ))
                .toList();

        return new ChatRoomResponseDto(
                room.getId(),
                room.getName(),
                room.getDescription(),
                room.isPrivate(),
                ownerDto,
                memberDtos
        );
    }
    public ChatRoomResponseDto joinRoom(Long roomId, String email) {

        ChatRoom room = chatRoomRepository.findById(roomId)
                .orElseThrow();

        User user = userRepository.findByEmail(email)
                .orElseThrow();

        room.getMembers().add(user);

        return toDto(chatRoomRepository.save(room));
    }
}