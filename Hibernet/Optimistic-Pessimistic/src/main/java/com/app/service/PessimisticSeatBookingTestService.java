package com.app.service;

import com.app.entity.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessimisticSeatBookingTestService {

    @Autowired
    private MovieTicketBookingService movieTicketBookingService;


    public void testPessimisticLocking(Long seatId) throws InterruptedException {
        Thread th1 = new Thread( ()->{
            try {
                movieTicketBookingService.bookSeatWithPessimistic(seatId);
            }catch (Exception e){
                System.out.println(Thread.currentThread().getName()+" Failed "+e.getMessage());
            }
        });


        Thread th2 = new Thread( ()->{
            try {
                movieTicketBookingService.bookSeatWithPessimistic(seatId);
            }catch (Exception e){
                System.out.println(Thread.currentThread().getName()+" Failed "+e.getMessage());
            }
        });


        th1.start();
        th2.start();
        th1.join();
        th2.join();
    }
}
