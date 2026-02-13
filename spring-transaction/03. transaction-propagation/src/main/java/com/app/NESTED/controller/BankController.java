package com.app.NESTED.controller;

import com.app.NESTED.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BankController {

    @Autowired
    private BankService bankService;

    // http://localhost:8080/api/transfer
    @GetMapping("/transfer")
    public String transfer() {
        bankService.transferMoney();
        return "Transfer Done";
    }
}

