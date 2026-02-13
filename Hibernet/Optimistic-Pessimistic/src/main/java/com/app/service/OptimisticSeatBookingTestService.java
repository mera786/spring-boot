package com.app.service;

import com.app.entity.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptimisticSeatBookingTestService {

    @Autowired
    private MovieTicketBookingService movieTicketBookingService;


    public void testOptimisticLocking(Long seatId) throws InterruptedException {

        Thread th1 = new Thread( ()->{
     try {
         System.out.println(Thread.currentThread().getName()+" is attempting to book the ticket");
         Seat seat = movieTicketBookingService.bookSeat(seatId);
         System.out.println(Thread.currentThread().getName()+" successfully booked the seat with version "+seat.getVersion());
     }catch (Exception e){
         System.out.println(Thread.currentThread().getName()+" Failed "+e.getMessage());
     }
        });


        Thread th2 = new Thread( ()->{
            try {
                System.out.println(Thread.currentThread().getName()+" is attempting to book the ticket");
                Seat seat = movieTicketBookingService.bookSeat(seatId);
                System.out.println(Thread.currentThread().getName()+" successfully booked the seat with version "+seat.getVersion());
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
