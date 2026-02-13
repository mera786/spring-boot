package com.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello/{id}")
    public ResponseEntity<String> hello(@PathVariable int id) {

        if (id <= 0) {
            return ResponseEntity
                    .badRequest()
                    .body("Invalid ID");
        }

        return ResponseEntity
                .ok("Hello Spring AOP, id = " + id);
    }
}

