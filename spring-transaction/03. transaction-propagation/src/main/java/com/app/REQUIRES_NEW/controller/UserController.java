package com.app.REQUIRES_NEW.controller;

import com.app.REQUIRES_NEW.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    // http://localhost:8080/api/register
    @PostMapping("/register")
    public String register() {
        userService.registerUser();
        return "Done";
    }
}

