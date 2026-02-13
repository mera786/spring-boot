package com.app.unidirectional.repository;

import com.app.unidirectional.entities.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume,Integer> {
}
