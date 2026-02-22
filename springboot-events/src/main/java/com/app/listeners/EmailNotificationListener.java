package com.app.listeners;

import com.app.events.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener {



    @EventListener
//    @Order(2)
    @Async
    public void handleOrderCreatedAndSendEmail(OrderCreatedEvent event) throws InterruptedException {
        System.out.println("Sending email for Order: "+event.getOrderId());
        Thread.sleep(3000);
        System.out.println("sent email for Order: "+event.getOrderId());

    }

}
