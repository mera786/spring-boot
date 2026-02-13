package com.app.repository;

import com.app.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicantJpaRepository extends JpaRepository<Applicant,Integer> {

    // these are called query methods
    List<Applicant> findByName(String name);
    List<Applicant> findByNameAndByEmail(String name,String email);
    List<Applicant> findByNameOrderByNameAsc(String name);


    // query annotation whatever rest things can't be achieve through query methods then use this
    @Query("SELECT a FROM Applicant a where a.name LIKE %:name%")
    List<Applicant> findApplicantByPartialName(@Param("name") String name);
}
