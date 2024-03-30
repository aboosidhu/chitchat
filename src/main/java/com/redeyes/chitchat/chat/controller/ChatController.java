package com.redeyes.chitchat.chat.controller;

import com.redeyes.chitchat.chat.model.Chat;
import com.redeyes.chitchat.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/chat")
@RestController
public class ChatController {
    @Autowired
    ChatService chatService;
    @PostMapping
    public Chat sendMessage(@RequestBody Chat chat){
        return chatService.saveChat(chat);
    }

    @GetMapping
    public List<Chat> getChatHistory(){
        return chatService.getChats();
    }

    @DeleteMapping
    public void deleteChat(@PathVariable("id")int id){
        chatService.deleteChat(id);
    }
}
