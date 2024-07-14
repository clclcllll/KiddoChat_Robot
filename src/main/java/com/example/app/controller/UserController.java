package com.example.app.controller;

import com.example.app.entity.User;
import com.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody WeChatOpenIdRequest weChatOpenIdRequest) {
        return userService.login(weChatOpenIdRequest.getWeChatOpenId());
    }

    @PostMapping("/change-password")
    public User changePassword(@RequestBody ChangePasswordRequest changePasswordRequest) {
        return userService.changePassword(changePasswordRequest.getUserId(), changePasswordRequest.getNewPassword());
    }

    private static class WeChatOpenIdRequest {
        private String weChatOpenId;

        public String getWeChatOpenId() {
            return weChatOpenId;
        }

        public void setWeChatOpenId(String weChatOpenId) {
            this.weChatOpenId = weChatOpenId;
        }
    }

    private static class ChangePasswordRequest {
        private Long userId;
        private String newPassword;

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getNewPassword() {
            return newPassword;
        }

        public void setNewPassword(String newPassword) {
            this.newPassword = newPassword;
        }
    }
}
