package com.app.bidirectional.service;

import com.app.bidirectional.entities.Applicant;
import com.app.bidirectional.entities.Resume;
import com.app.bidirectional.repository.ApplicantRepository;
import com.app.bidirectional.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicantService {

@Autowired
private ApplicantRepository applicantRepository;





    public Applicant addApplicant(Applicant applicant){
        // either saved resume before and then save applicant entity or use cascade
        // to avoid issue like 'save the transient instance before flushing'
        Resume resume = applicant.getResume();
        if(resume !=null){
            resume.setApplicant(applicant);
        }
        return applicantRepository.save(applicant);
    }
}
