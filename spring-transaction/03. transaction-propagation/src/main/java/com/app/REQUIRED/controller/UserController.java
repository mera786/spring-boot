package com.app.REQUIRED.controller;


import com.app.REQUIRED.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // http://localhost:8080/api/users/register
    @PostMapping("/register")
    public String register() {
        userService.registerUser();
        return "User Registered Successfully";
    }
}

