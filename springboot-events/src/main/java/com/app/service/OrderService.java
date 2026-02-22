package com.app.service;

import com.app.events.OrderCreatedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderService {


    // it is interface in spring help us to publish the events.
    private final ApplicationEventPublisher publisher;

    public OrderService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }


    public void createOrder(String orderId , double amount) {
        // Order creation logic
        System.out.println("Order created: " + orderId);
        publisher.publishEvent(new OrderCreatedEvent(orderId,amount));
    }
}
