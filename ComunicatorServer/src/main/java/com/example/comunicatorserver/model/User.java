package com.example.comunicatorserver.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "chat_name")
public class User{
    @Id
    @GeneratedValue
    private Long userId;
    @Column(name = "user_name")
    private String userName;
    @ManyToMany
    private List<Chat> userChats;
}