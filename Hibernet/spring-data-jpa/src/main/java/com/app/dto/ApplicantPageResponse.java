package com.app.dto;

import com.app.entity.Applicant;
import lombok.Data;

import java.util.List;

@Data
public class ApplicantPageResponse {

    private List<Applicant> applicants;
    private long totalElements;
    private int totalPages;
    private int currentPage;
    private int pageSize;
}
