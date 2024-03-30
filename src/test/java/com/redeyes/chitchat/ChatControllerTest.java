package com.redeyes.chitchat;

import com.redeyes.chitchat.chat.model.Chat;
import com.redeyes.chitchat.chat.service.ChatService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChatControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Mock
    ChatService chatService;

    @Test
    public void sendMessage() throws MalformedURLException {
        Chat chat = new Chat();
        chat.setChatId(123);
        chat.setMessage("abc");
        chat.setUserId(123);
        ResponseEntity<Chat> response = restTemplate.postForEntity(
                new URL("http://localhost:" + port + "/chat").toString(), chat, Chat.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getMessages() throws MalformedURLException {
        ResponseEntity<Object> response = restTemplate.getForEntity(
                new URL("http://localhost:" + port + "/chat").toString(), Object.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void deleteMessages() throws MalformedURLException {
        ResponseEntity<Void> response = restTemplate.exchange(new URL("http://localhost:" + port + "/chat").toString(), HttpMethod.DELETE, HttpEntity.EMPTY, Void.class);
        Mockito.doNothing().when(chatService).deleteChat(123);
    }

}
