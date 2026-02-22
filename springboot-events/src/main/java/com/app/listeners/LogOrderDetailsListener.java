package com.app.listeners;

import com.app.events.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class LogOrderDetailsListener {


    @EventListener
//    @Order(1)
    @Async
    public void logOrderCreated(OrderCreatedEvent event) throws InterruptedException {
        System.out.println("Order Placed For Order Id: " + event.getOrderId());
        Thread.sleep(1000);
        System.out.println("logOrderCreated"+event.getOrderId());
    }
}
