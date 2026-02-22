package com.app.controller;

import com.app.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {


    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping("/{orderId}")
    public String placeOrder(@PathVariable String orderId, @RequestParam double amount) {
        orderService.createOrder(orderId,amount);
        return "Order placed successfully: " + orderId;
    }
}
