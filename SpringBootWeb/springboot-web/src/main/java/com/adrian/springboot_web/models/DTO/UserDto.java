package com.adrian.springboot_web.models.DTO;

import com.adrian.springboot_web.models.User;

public class UserDto {
    
    private String title;
    private String name;
    private String lastname;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    

}
