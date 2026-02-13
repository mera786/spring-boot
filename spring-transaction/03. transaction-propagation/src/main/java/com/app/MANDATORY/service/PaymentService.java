package com.app.MANDATORY.service;

import com.app.MANDATORY.entity.Payment;
import com.app.MANDATORY.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional(propagation = Propagation.MANDATORY)
    public void processPayment() {
        paymentRepository.save(new Payment("PAID"));
        System.out.println("Payment Saved");
    }
}

