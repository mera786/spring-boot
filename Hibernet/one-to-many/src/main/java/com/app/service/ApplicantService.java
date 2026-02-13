package com.app.service;

import com.app.entities.Applicant;
import com.app.entities.Application;
import com.app.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;


    public Applicant saveApplicant(Applicant applicant){
        List<Application> applications = applicant.getApplications();
        if (applications !=null){
            for (Application application : applications) {
                application.setApplicant(applicant);
            }
        }

        return applicantRepository.save(applicant);
    }
}
