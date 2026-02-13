package com.app.controller;

import com.app.dto.ApplicantPageResponse;
import com.app.entity.Applicant;
import com.app.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;



    @GetMapping
    public List<Applicant> getAllApplicants(){
        return applicantService.getAllApplicants();
    }

    @PostMapping("/save")
    public Applicant saveApplicant(@RequestBody Applicant applicant){
       return applicantService.saveApplicant(applicant);
    }


    @GetMapping("/page")
    public ApplicantPageResponse getApplicantsWithPagination(
            @RequestParam int page,
            @RequestParam int size
    ){

        return applicantService.getApplicants(page, size);
    }
}
