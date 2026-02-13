package com.app.repository;

import com.app.entity.Seat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

public interface SeatRepository extends JpaRepository<Seat,Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT s from Seat s where s.id= :seatId")
    Seat findByIdAndLock(Long seatId);
}
