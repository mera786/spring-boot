package com.app.MANDATORY.entity;


import jakarta.persistence.*;

@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    public OrderEntity() {}

    public OrderEntity(String productName) {
        this.productName = productName;
    }

    // getters & setters
}

