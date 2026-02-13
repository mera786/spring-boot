package com.app.repository;

import com.app.entity.Applicant;
import org.springframework.data.repository.CrudRepository;

public interface ApplicantCrudRepository extends CrudRepository<Applicant,Integer> {
}
