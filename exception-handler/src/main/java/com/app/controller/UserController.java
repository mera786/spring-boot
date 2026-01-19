package com.app.controller;



import com.app.entity.User;
import com.app.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> userList = new ArrayList<>();

    // Add user
    @PostMapping
    public User addUser(@RequestBody User user) {
        userList.add(user);
        return user;
    }

    // Get user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {

        return userList.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new UserNotFoundException("User not found with id: " + id));
    }
}

