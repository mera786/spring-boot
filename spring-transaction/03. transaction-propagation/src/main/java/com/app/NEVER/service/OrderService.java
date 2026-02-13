package com.app.NEVER.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private ReportService reportService;

    @Transactional
    public void placeOrder() {
        System.out.println("Order placed...");

        reportService.generateReport(); // ❌ Will throw exception
    }
}

