package com.app.MANDATORY.service;


import com.app.MANDATORY.entity.OrderEntity;
import com.app.MANDATORY.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentService paymentService;

    @Transactional
    public void placeOrder() {
        orderRepository.save(new OrderEntity("Laptop"));

        paymentService.processPayment(); // MUST be inside TX
    }
}

