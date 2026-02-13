package com.app.controller;

import com.app.entities.Application;
import com.app.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;


    @PostMapping("/{applicantId}")
    public ResponseEntity<Application> createApplication(@PathVariable int applicantId, @RequestBody Application application){
        Application savedApplication = applicationService.saveApplication(applicantId,application);
        return new ResponseEntity<>(savedApplication, HttpStatus.CREATED);
    }
}
