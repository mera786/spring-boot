package com.app.listeners;

import com.app.events.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class HighValueOrderListener {


    @EventListener(condition = "#event.amount >1000")
    public void handleHighValueOrder(OrderCreatedEvent event){
        System.out.println("high value order detected! orderId: "+event.getOrderId()+"Ammount: "+event.getAmount()  );

        // explicitly thrown exception
        throw new RuntimeException("runtime exception thrown");
    }
}
