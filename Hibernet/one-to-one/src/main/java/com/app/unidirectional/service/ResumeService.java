package com.app.unidirectional.service;

import com.app.unidirectional.entities.Applicant;
import com.app.unidirectional.entities.Resume;
import com.app.unidirectional.repository.ApplicantRepository;
import com.app.unidirectional.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResumeService {

@Autowired
private ApplicantRepository applicantRepository;

@Autowired
private ResumeRepository resumeRepository;



    public Resume addResume(int applicantId, Resume resume){
        Optional<Applicant> optionalApplicant = applicantRepository.findById(applicantId);
        if(optionalApplicant.isPresent()){
            Applicant applicant = optionalApplicant.get();
            resume.setApplicant(applicant);
           return resumeRepository.save(resume);
        }else {
            throw new RuntimeException("Applicant not found with id : "+applicantId);
        }

    }
}
