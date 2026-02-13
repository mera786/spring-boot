package com.app.service;

import com.app.entity.Seat;
import com.app.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieTicketBookingService {

    @Autowired
    private SeatRepository seatRepository;


    @Transactional
    public Seat bookSeat(Long seatId){
        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new RuntimeException("seat not found with id: " + seatId));

        System.out.println(Thread.currentThread().getName()+" fetched with version "+seat.getVersion());

        if(seat.isBooked()){
            throw new RuntimeException("seat already booked!");
        }

        // booking seat
        seat.setBooked(true);
        // version check will occurs here
        return seatRepository.save(seat);
    }




    @Transactional
    public void bookSeatWithPessimistic(Long seatId){

        System.out.println(Thread.currentThread().getName()+" is attempting to fetch the seat");

        // the seat with pessimistic lock
        Seat seat = seatRepository.findByIdAndLock(seatId);

        System.out.println("acquire the lock for seat id: "+seatId);


        if(seat.isBooked()){
            System.out.println(Thread.currentThread().getName()+" Failed seatId "+seatId+" is already booked");
            throw new RuntimeException("seat already booked!");
        }

        // booking seat
        System.out.println(Thread.currentThread().getName()+" booking the seat "+seatId);
        seat.setBooked(true);
        // version check will occurs here
         seatRepository.save(seat);
        System.out.println(Thread.currentThread().getName()+" successfully booked the seat with id : "+seatId);
    }
}
