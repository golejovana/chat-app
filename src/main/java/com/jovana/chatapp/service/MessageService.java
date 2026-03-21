package com.jovana.chatapp.service;

import com.jovana.chatapp.dto.MessageResponseDto;
import com.jovana.chatapp.dto.UserResponseDto;
import com.jovana.chatapp.entity.ChatRoom;
import com.jovana.chatapp.entity.Message;
import com.jovana.chatapp.entity.User;
import com.jovana.chatapp.repository.ChatRoomRepository;
import com.jovana.chatapp.repository.MessageRepository;
import com.jovana.chatapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final ChatRoomRepository chatRoomRepository;
    private final UserRepository userRepository;

    public MessageResponseDto sendMessage(Long roomId, String content, String email) {
        ChatRoom room = chatRoomRepository.findById(roomId)
                .orElseThrow();

        User sender = userRepository.findByEmail(email)
                .orElseThrow();

        Message message = Message.builder()
                .content(content)
                .timestamp(LocalDateTime.now())
                .sender(sender)
                .chatRoom(room)
                .build();

        Message saved = messageRepository.save(message);
        return toDto(saved);
    }

    public List<MessageResponseDto> getMessages(Long roomId) {
        return messageRepository.findByChatRoomIdOrderByTimestampAsc(roomId)
                .stream()
                .map(this::toDto)
                .toList();
    }

    private MessageResponseDto toDto(Message message) {
        User sender = message.getSender();

        UserResponseDto senderDto = new UserResponseDto(
                sender.getId(),
                sender.getUsername(),
                sender.getEmail()
        );

        return new MessageResponseDto(
                message.getId(),
                message.getContent(),
                message.getTimestamp(),
                senderDto,
                message.getChatRoom().getId()
        );
    }
}