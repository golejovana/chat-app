package com.jovana.chatapp.dto;

public class SendMessageRequestDto {

    private String content;

    public SendMessageRequestDto() {
    }

    public SendMessageRequestDto(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}