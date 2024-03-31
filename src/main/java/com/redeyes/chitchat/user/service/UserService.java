package com.redeyes.chitchat.user.service;

import com.redeyes.chitchat.user.model.User;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    User findUser(User user);
    public Optional<User> findById(int id);
}
