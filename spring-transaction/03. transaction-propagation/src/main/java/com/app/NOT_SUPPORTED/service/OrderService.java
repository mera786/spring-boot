package com.app.NOT_SUPPORTED.service;

import com.app.NOT_SUPPORTED.entity.Order;
import com.app.NOT_SUPPORTED.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private LogService logService;

    @Transactional
    public void placeOrder() {
        orderRepository.save(new Order("Laptop"));

        logService.saveLog(); // Should NOT be in transaction

        // Force error
        int x = 10 / 0;
    }
}

