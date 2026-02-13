package com.app.REQUIRES_NEW.service;

import com.app.REQUIRES_NEW.entity.AuditLog;
import com.app.REQUIRES_NEW.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuditService {

    @Autowired
    private AuditRepository auditRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveAuditLog() {
        auditRepository.save(new AuditLog("User Registration Attempt"));
    }
}

