package com.app.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String mobile;
    private String status;

    @OneToMany(mappedBy = "applicant",cascade = CascadeType.ALL)
    private List<Application> applications = new ArrayList<>();

}
