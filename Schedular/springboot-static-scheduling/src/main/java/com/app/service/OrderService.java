package com.app.service;

import com.app.dto.OrderRequest;
import com.app.entity.Order;
import com.app.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {


    @Autowired
    private OrderRepository orderRepository;


    public Order createOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setCustomerEmail(order.getCustomerEmail());
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
         return orderRepository.findAll();
    }
}
