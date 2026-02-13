package com.app.service;

import com.app.dto.ApplicantPageResponse;
import com.app.entity.Applicant;
import com.app.repository.ApplicantCrudRepository;
import com.app.repository.ApplicantJpaRepository;
import com.app.repository.ApplicantPagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantCrudRepository applicantRepository;

    @Autowired
    private ApplicantPagingAndSortingRepository pagingAndSortingRepository;


    @Autowired
    private ApplicantJpaRepository applicantJpaRepository;

    public List<Applicant> getAllApplicants(){
        Iterable<Applicant> all = applicantRepository.findAll();
        List<Applicant> list = new ArrayList<>();
        all.forEach(list::add);
        return list;
    }


    public Applicant saveApplicant(Applicant applicant){
        return applicantRepository.save(applicant);
    }


    public ApplicantPageResponse getApplicants(int page, int size) {

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Applicant> pageData = pagingAndSortingRepository.findAll(pageRequest);

        ApplicantPageResponse response = new ApplicantPageResponse();
        response.setApplicants(pageData.getContent());
        response.setTotalElements(pageData.getTotalElements());
        response.setTotalPages(pageData.getTotalPages());
        response.setCurrentPage(pageData.getNumber());
        response.setPageSize(pageData.getSize());

        return response;
    }


    public List<Applicant> findByName(String name){
       return applicantJpaRepository.findByName(name);
    }

}
