package com.adrian.springboot_errors.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.adrian.springboot_errors.models.domain.User;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users;

    public UserServiceImpl (){
        this.users = new ArrayList<>();
        users.add(new User(1L, "Adrian", "Gomez"));
        users.add(new User(2L, "John", "Doe"));
        users.add(new User(3L, "Jane", "Doe"));
        users.add(new User(4L, "Tomas", "Smith"));
        users.add(new User(5L, "Jhon", "Smith"));
        users.add(new User(6L, "Jane", "Smith"));
    }

    @Override
    public List<User> findAll() {
            return users;       
    }

    @Override
    public Optional<User> findById(Long id) {
        User user = null;
        for(User u: users){
            if(u.getId().equals(id)){
                user = u;
                break;
            }
        }
        return Optional.ofNullable(user);
    }

}
