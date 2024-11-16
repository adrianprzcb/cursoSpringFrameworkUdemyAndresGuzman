package com.adrian.springboot_web.models.DTO;

import com.adrian.springboot_web.models.User;

public class UserDto {
    
    private String title;
    private User User;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public User getUser() {
        return User;
    }
    public void setUser(User user) {
        User = user;
    }

    

}
