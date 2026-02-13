package com.app.REQUIRES_NEW.repository;

import com.app.REQUIRES_NEW.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<AuditLog, Long> {}