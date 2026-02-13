package com.app.controller;

import com.app.service.OptimisticSeatBookingTestService;
import com.app.service.PessimisticSeatBookingTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class SeatController {


    @Autowired
    private OptimisticSeatBookingTestService optimisticSeatBookingTestService;

    @Autowired
    private PessimisticSeatBookingTestService pessimisticSeatBookingTestService;

    @GetMapping("/optimistic/{seatId}")
    public String testOptimistic(@PathVariable Long seatId)throws InterruptedException{
        optimisticSeatBookingTestService.testOptimisticLocking(seatId);
    return "optimistic locking test started , check logs for results";
    }


    @GetMapping("/pessimistic/{seatId}")
    public String testPessimistic(@PathVariable Long seatId)throws InterruptedException{
        pessimisticSeatBookingTestService.testPessimisticLocking(seatId);
        return "pessimistic locking test started , check logs for results";
    }
}
