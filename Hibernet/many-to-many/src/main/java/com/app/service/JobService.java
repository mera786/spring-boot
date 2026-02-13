package com.app.service;

import com.app.entities.Applicant;
import com.app.entities.Job;
import com.app.repository.ApplicantRepository;
import com.app.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplicantRepository applicantRepository;

    public Job createJob(Job job){
        return jobRepository.save(job);
    }


    public Applicant addJobToApplicant(int applicantId,int jobId){
        Optional<Applicant> applicant = applicantRepository.findById(applicantId);
        Optional<Job> job = jobRepository.findById(jobId);

        if (applicant.isPresent() && job.isPresent()){
            applicant.get().getJobs().add(job.get());
            applicantRepository.save(applicant.get());
            return applicant.get();
        }else {
            throw new IllegalArgumentException("Applicant or Job not found");
        }
    }
}
