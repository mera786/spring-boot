package com.app.unidirectional.repository;

import com.app.unidirectional.entities.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant,Integer> {
}
