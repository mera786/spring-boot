package com.app.REQUIRED.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;

    public Role() {}

    public Role(String roleName) {
        this.roleName = roleName;
    }

    // getters & setters
}

