package com.app.controller;

import com.app.entities.Applicant;
import com.app.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {


    @Autowired
    private ApplicantService applicantService;


    @PostMapping
    public ResponseEntity<Applicant> createApplicant(@RequestBody Applicant applicant){
        Applicant savedApplicant = applicantService.saveApplicant(applicant);
        return ResponseEntity.ok(savedApplicant);
    }



}
