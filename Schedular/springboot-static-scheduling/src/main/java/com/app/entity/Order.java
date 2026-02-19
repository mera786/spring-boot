package com.app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String customerEmail;
    private String status;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist(){
        this.status="PENDING";
        this.createdAt=LocalDateTime.now();
    }
}
