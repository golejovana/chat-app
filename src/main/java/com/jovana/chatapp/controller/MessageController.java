package com.jovana.chatapp.controller;

import com.jovana.chatapp.dto.MessageResponseDto;
import com.jovana.chatapp.dto.SendMessageRequestDto;
import com.jovana.chatapp.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/{roomId}")
    public MessageResponseDto sendMessage(@PathVariable Long roomId,
                                          @RequestBody SendMessageRequestDto request,
                                          Principal principal) {
        return messageService.sendMessage(roomId, request.getContent(), principal.getName());
    }

    @GetMapping("/{roomId}")
    public List<MessageResponseDto> getMessages(@PathVariable Long roomId,
                                                Principal principal) {
        return messageService.getMessages(roomId, principal.getName());
    }
}