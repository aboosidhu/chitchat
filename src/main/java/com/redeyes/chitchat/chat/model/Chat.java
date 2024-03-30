package com.redeyes.chitchat.chat.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Chat {
    @Id
    @GeneratedValue
    private int chatId;
    private String message;

    private int userId;
}
