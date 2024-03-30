package com.redeyes.chitchat;

import com.redeyes.chitchat.user.model.User;
import com.redeyes.chitchat.user.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ChitchatApplication {

	@Autowired
	UserService userService;

	@PostConstruct
	void insertUser(){
		User user=new User(1,"aboo","123");
		User user1=new User(2,"sidhu","456");
		List<User> userList= Arrays.asList(user,user1);
		userList.stream().forEach(u->userService.saveUser(u));
	}
	public static void main(String[] args) {
		SpringApplication.run(ChitchatApplication.class, args);
	}

}
