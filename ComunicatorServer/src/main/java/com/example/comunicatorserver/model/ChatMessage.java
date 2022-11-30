package com.example.comunicatorserver.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "chat_messages")
public class ChatMessage {
    @Generated
    @Id
    Long messageId;
    @ManyToOne
    @JoinColumn
    Chat chat;
    @OneToOne
    User fromUserId;
    String messageBody;
    Date timestamp;
}