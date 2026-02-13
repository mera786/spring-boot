package com.app.bidirectional.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
   @JsonIgnore
   private Applicant applicant;

}
