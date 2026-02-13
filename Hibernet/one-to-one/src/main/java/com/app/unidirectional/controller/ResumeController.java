package com.app.unidirectional.controller;

import com.app.unidirectional.entities.Resume;
import com.app.unidirectional.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ResumeController {


    @Autowired
    private ResumeService resumeService;
/*
Note:- before adding to resume for any applicant, applicant should exist already.
 */
    // http://localhost:8080/api/1/resume
    @PostMapping("/{applicantId}/resume")
    public ResponseEntity<Resume> addResume(@PathVariable int applicantId, @RequestBody Resume resume){
        Resume addedResume = resumeService.addResume(applicantId, resume);
        return  new ResponseEntity<>(addedResume, HttpStatus.CREATED);
    }




}
