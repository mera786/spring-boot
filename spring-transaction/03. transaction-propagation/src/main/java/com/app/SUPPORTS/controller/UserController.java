package com.app.SUPPORTS.controller;

import com.app.SUPPORTS.entity.User;
import com.app.SUPPORTS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String create() {
        userService.createUser();
        return "User Created";
    }


    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        return userService.getUser(id);
    }
}

