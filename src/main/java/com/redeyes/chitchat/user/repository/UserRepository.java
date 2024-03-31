package com.redeyes.chitchat.user.repository;

import com.redeyes.chitchat.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT u FROM User u WHERE u.username= ?1 AND u.password=?2")
    User findUser(String username, String password);
}
