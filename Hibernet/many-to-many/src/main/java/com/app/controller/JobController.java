package com.app.controller;

import com.app.entities.Applicant;
import com.app.entities.Job;
import com.app.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;


    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job){
        Job createdJob = jobService.createJob(job);
        return ResponseEntity.ok(createdJob);
    }


    @PostMapping("/add-job-to-applicant")
    public ResponseEntity<Applicant> addJobToApplicant(@RequestParam int applicantId,@RequestParam int jobId){
        Applicant updatedApplicant = jobService.addJobToApplicant(applicantId, jobId);
        return ResponseEntity.ok(updatedApplicant);

    }
}
