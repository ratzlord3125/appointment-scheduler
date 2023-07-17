package com.oops.ratzlord.appointmentscheduler.dao;

import com.oops.ratzlord.appointmentscheduler.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Integer> {

}
