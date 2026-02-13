package com.app.unidirectional.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   private String content;

   @OneToOne
   @JoinColumn(name = "applicantId",nullable = false)
   private Applicant applicant;

}
