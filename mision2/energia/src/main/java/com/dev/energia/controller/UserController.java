package com.dev.energia.controller;

import com.dev.energia.model.User;
import com.dev.energia.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/users")

public class UserController {
    private final UserRepository userRepository;
    public UserController(UserRepository userRepository){
        this.userRepository =userRepository;
    }
    @PostMapping
    public User create(@RequestBody User user) {
        
        return userRepository.save(user);
    }
    @GetMapping
    public List<User> findAll(){
        return userRepository.findAll();
    }
    
}