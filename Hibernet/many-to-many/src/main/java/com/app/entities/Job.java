package com.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Job {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

     private String title;
     private String description;

     @ManyToMany(mappedBy = "jobs")
     @JsonIgnore
     private List<Applicant> applicants= new ArrayList<>();

}
