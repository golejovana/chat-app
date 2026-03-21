package com.jovana.chatapp.controller;

import com.jovana.chatapp.dto.ChatRoomResponseDto;
import com.jovana.chatapp.entity.ChatRoom;
import com.jovana.chatapp.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    @PostMapping
    public ChatRoomResponseDto createRoom(@RequestBody ChatRoom request, Principal principal) {
        return chatRoomService.createRoom(
                request.getName(),
                request.getDescription(),
                request.isPrivate(),
                principal.getName()
        );
    }

    @GetMapping
    public List<ChatRoomResponseDto> getPublicRooms() {
        return chatRoomService.getAllPublicRooms();
    }

    @PostMapping("/{roomId}/join")
    public ChatRoomResponseDto joinRoom(@PathVariable Long roomId,
                             Authentication authentication) {

        String email = authentication.getName(); // iz JWT-a

        return chatRoomService.joinRoom(roomId, email);
    }
}