package com.jovana.chatapp.dto;

import java.util.List;

public class ChatRoomResponseDto {

    private Long id;
    private String name;
    private String description;
    private boolean isPrivate;
    private UserResponseDto owner;
    private List<UserResponseDto> members;

    public ChatRoomResponseDto() {
    }

    public ChatRoomResponseDto(Long id, String name, String description, boolean isPrivate,
                               UserResponseDto owner, List<UserResponseDto> members) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isPrivate = isPrivate;
        this.owner = owner;
        this.members = members;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public UserResponseDto getOwner() {
        return owner;
    }

    public void setOwner(UserResponseDto owner) {
        this.owner = owner;
    }

    public List<UserResponseDto> getMembers() {
        return members;
    }

    public void setMembers(List<UserResponseDto> members) {
        this.members = members;
    }
}