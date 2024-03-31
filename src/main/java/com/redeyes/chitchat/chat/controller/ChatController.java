package com.redeyes.chitchat.chat.controller;

import com.redeyes.chitchat.chat.exception.UnAuthorizedException;
import com.redeyes.chitchat.chat.model.Chat;
import com.redeyes.chitchat.chat.service.ChatService;
import com.redeyes.chitchat.user.model.User;
import com.redeyes.chitchat.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/chat")
@RestController
public class ChatController {
    @Autowired
    ChatService chatService;

    @Autowired
    UserService userService;

    @PostMapping("/authenticate")
    public String authenticateUser(@RequestBody User user) {
        User existingUser = userService.findUser(user);
        if (existingUser != null) {
            existingUser.setJoined(true);
            userService.saveUser(existingUser);
            return "authenticated";
        } else {
            return "invalid user";
        }
    }

    @PostMapping
    public Chat sendMessage(@RequestBody Chat chat) {
        Optional<User> existingUser = userService.findById(chat.getUserId());
        if (existingUser.isPresent() && existingUser.get().isJoined()) {
            return chatService.saveChat(chat);
        } else {
            throw new UnAuthorizedException("Invalid user");
        }

    }

    @GetMapping
    public List<Chat> getChatHistory() {
        return chatService.getChats();
    }

    @DeleteMapping("/{id}")
    public void deleteChat(@PathVariable("id") int id) {
        chatService.deleteChat(id);
    }
}
