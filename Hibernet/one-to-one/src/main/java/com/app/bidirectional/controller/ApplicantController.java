package com.app.bidirectional.controller;

import com.app.bidirectional.entities.Applicant;
import com.app.bidirectional.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApplicantController {


    @Autowired
    private ApplicantService applicantService;

    @PostMapping("/applicant")
    public ResponseEntity<Applicant> addApplicant(@RequestBody Applicant applicant){
        Applicant addedApplicant = applicantService.addApplicant(applicant);
        return  new ResponseEntity<>(applicant, HttpStatus.CREATED);
    }




}
