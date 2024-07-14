package com.example.app.service;

import com.example.app.entity.User;
import com.example.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public User login(String weChatOpenId) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByWeChatOpenId(weChatOpenId));
        return userOptional.orElseThrow(() -> new IllegalStateException("User not found"));
    }

    public User changePassword(Long userId, String newPassword) {
        Optional<User> userOptional = userRepository.findById(userId);
        User user = userOptional.orElseThrow(() -> new IllegalStateException("User not found"));
        user.setPassword(newPassword);
        return userRepository.save(user);
    }
}
