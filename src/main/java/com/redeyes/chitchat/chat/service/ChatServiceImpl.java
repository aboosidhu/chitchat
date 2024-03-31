package com.redeyes.chitchat.chat.service;

import com.redeyes.chitchat.chat.model.Chat;
import com.redeyes.chitchat.chat.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    ChatRepository chatRepository;

    @Override
    public Chat saveChat(Chat chat) {
        return chatRepository.save(chat);
    }


    public List<Chat> getChats() {
        return chatRepository.findAll();
    }

    @Override
    public void deleteChat(int id) {
        chatRepository.deleteById(id);
    }
}
