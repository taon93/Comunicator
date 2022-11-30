package com.example.comunicatorserver.controller;

import com.example.comunicatorserver.model.Message;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/chat")
public class ChatMessageController {
    @PostMapping("/register/{userName}")
    public registerNewUser()
    @PostMapping("/{chatId}")
    public postMessageToTheChat(@PathVariable Long chatId, Message message) {

    }

}
