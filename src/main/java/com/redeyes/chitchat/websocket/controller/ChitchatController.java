package com.redeyes.chitchat.websocket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class ChitchatController {
    Logger logger = LoggerFactory.getLogger(ChitchatController.class);
//    @MessageMapping("/sendMessage")
//    @SendTo("/topic/public")
//    public Chitchat sendMessage(@Payload Chitchat chitchat){
//        logger.info("send message request payload,{}",chitchat);
//        return chitchat;
//    }
//
//    @MessageMapping("/addUser")
//    @SendTo("/topic/public")
//    public Chitchat addUser(@Payload Chitchat chitchat, SimpMessageHeaderAccessor simpMessageHeaderAccessor){
//        logger.info("add user request payload,{}",chitchat);
//        simpMessageHeaderAccessor.getSessionAttributes().put("username",chitchat.getSender());
//        return chitchat;
//    }
}
