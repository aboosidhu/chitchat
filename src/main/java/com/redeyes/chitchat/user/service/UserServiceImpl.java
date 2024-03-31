package com.redeyes.chitchat.user.service;

import com.redeyes.chitchat.user.model.User;
import com.redeyes.chitchat.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUser(User user) {
        System.out.println(user.getUsername()+user.getPassword());
        return userRepository.findUser(user.getUsername(),user.getPassword());
    }

    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }
}
