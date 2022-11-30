package com.example.comunicatorserver.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "chats")
public class Chat {
    @Id
    private Long chatId;
    @OneToMany(mappedBy = "chat")
    @Column(name = "chat_messages")
    private List<ChatMessage> chatMessages;
    @ManyToMany
    @Column(name = "users")
    private List<User> users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Chat chat = (Chat) o;
        return chatId != null && Objects.equals(chatId, chat.chatId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
