package com.app.service;

import com.app.entities.Applicant;
import com.app.entities.Application;
import com.app.repository.ApplicantRepository;
import com.app.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ApplicantRepository applicantRepository;


    public Application saveApplication(int applicantId, Application application){
        Optional<Applicant> optionalApplication = applicantRepository.findById(applicantId);
        if (optionalApplication.isPresent()){
            Applicant applicant = optionalApplication.get();
            application.setApplicant(applicant);
            return applicationRepository.save(application);
        }else {
            throw new RuntimeException("Applicant not found with id: "+applicantId);
        }

    }
}
