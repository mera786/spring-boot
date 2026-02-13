package com.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String status;
    private String position;

    @ManyToOne
    @JoinColumn(name = "applicant_id",nullable = false)
    @JsonIgnore
    private Applicant applicant;

}
