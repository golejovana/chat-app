package com.jovana.chatapp.dto;

import java.time.LocalDateTime;

public class MessageResponseDto {

    private Long id;
    private String content;
    private LocalDateTime timestamp;
    private UserResponseDto sender;
    private Long chatRoomId;

    public MessageResponseDto() {
    }

    public MessageResponseDto(Long id, String content, LocalDateTime timestamp, UserResponseDto sender, Long chatRoomId) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
        this.sender = sender;
        this.chatRoomId = chatRoomId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public UserResponseDto getSender() {
        return sender;
    }

    public void setSender(UserResponseDto sender) {
        this.sender = sender;
    }

    public Long getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(Long chatRoomId) {
        this.chatRoomId = chatRoomId;
    }
}