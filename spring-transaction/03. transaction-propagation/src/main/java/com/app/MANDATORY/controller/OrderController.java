package com.app.MANDATORY.controller;
import com.app.MANDATORY.service.OrderService;
import com.app.MANDATORY.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PaymentService paymentService;

    // ✅ Correct way (MANDATORY works)
    @GetMapping("/order")
    public String placeOrder() {
        orderService.placeOrder();
        return "Order + Payment Done";
    }

    // ❌ Wrong way (MANDATORY will throw exception)
    @GetMapping("/payment")
    public String directPayment() {
        paymentService.processPayment();
        return "Payment Done";
    }
}

