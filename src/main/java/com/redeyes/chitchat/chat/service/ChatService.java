package com.redeyes.chitchat.chat.service;

import com.redeyes.chitchat.chat.model.Chat;

import java.util.List;

public interface ChatService {
    Chat saveChat(Chat chat);

    List<Chat> getChats();

    void deleteChat(int id);
}
