package com.app.controller;

import com.app.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @GetMapping("/check")
    public String testingPaymentServiceMethod(){
        paymentService.pay();
        return "done";
    }
}
