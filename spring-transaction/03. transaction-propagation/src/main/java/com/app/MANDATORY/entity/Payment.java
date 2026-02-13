package com.app.MANDATORY.entity;


import jakarta.persistence.*;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    public Payment() {}

    public Payment(String status) {
        this.status = status;
    }

    // getters & setters
}

