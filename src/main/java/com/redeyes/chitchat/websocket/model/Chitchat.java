package com.redeyes.chitchat.websocket.model;

import lombok.Data;

@Data
public class Chitchat {
    private String content;
    private String sender;

    private MesageType type;
}
