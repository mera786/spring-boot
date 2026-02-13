package com.app.bidirectional.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String mobile;
    private String status;
    // cascade = CascadeType.ALL:- first resume will be added then applicant, same for delete first resume then applicant
    @OneToOne(mappedBy = "applicant",cascade = CascadeType.ALL)
    private Resume resume;

}
