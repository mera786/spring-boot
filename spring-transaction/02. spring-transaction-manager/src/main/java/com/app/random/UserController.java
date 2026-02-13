package com.app.random;

import com.app.service.FirstProgrammaticApproach;
import com.app.service.SecondProgrammaticApproach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;
    @Autowired
    private FirstProgrammaticApproach programmaticApproach;
    @Autowired
    private SecondProgrammaticApproach secondProgrammaticApproach;


    @PostMapping
    public String AddBook(){
        secondProgrammaticApproach.update();
        programmaticApproach.updateUser();
        userService.bookAdd();
        return "ok";
    }
}
