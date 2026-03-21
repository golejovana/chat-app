package com.jovana.chatapp.repository;

import com.jovana.chatapp.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByChatRoomIdOrderByTimestampAsc(Long chatRoomId);
}