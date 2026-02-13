package com.app.controller;

import com.app.entity.User;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }


    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
}

