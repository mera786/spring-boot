package com.app.transactionalAnnotation.controller;

import com.app.transactionalAnnotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController { // Controller (Method call goes via proxy)

    @Autowired
    private UserService userService;

    @GetMapping("/create")
    public String create() {
        userService.createUser();
        return "Done";
    }
}

