package com.app.NEVER.service;

import com.app.NEVER.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Transactional(propagation = Propagation.NEVER)
    public void generateReport() {
        reportRepository.findAll(); // Heavy query
        System.out.println("Report Generated");
    }
}

