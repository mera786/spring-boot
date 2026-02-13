package com.app.service;

import com.app.entities.Applicant;
import com.app.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;


    public Applicant saveApplicant(Applicant applicant){
        return applicantRepository.save(applicant);
    }
}
