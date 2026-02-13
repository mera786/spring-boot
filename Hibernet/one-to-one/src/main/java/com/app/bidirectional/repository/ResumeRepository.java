package com.app.bidirectional.repository;

import com.app.bidirectional.entities.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume,Integer> {
}
