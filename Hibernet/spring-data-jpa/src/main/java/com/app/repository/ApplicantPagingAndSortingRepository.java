package com.app.repository;

import com.app.entity.Applicant;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApplicantPagingAndSortingRepository extends PagingAndSortingRepository<Applicant,Integer> {
}
