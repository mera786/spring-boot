package com.app.scheduling;

import com.app.entity.Order;
import com.app.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderSchedular {

    @Autowired
    private OrderRepository orderRepository;


//    @Scheduled(fixedRate = 5000)
//@Scheduled(fixedDelay = 5000)
//@Scheduled(initialDelay = 10000, fixedRate = 5000)
//@Scheduled(cron = "* * * * * *")
    public void processPendingOrders(){
        List<Order> orders = orderRepository.findByStatus("PENDING");

        orders
                .forEach(order -> {
                    order.setStatus("COMPLETED");
                    System.out.println(order.getCustomerEmail());
                    orderRepository.save(order);
                });

        System.out.println("processed {} pending orders."+orders.size());
    }
}
