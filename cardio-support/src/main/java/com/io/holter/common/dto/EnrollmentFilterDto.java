package com.io.holter.common.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EnrollmentFilterDto {

    private String enrollmentType;
    private String status;
    private String patientName;
    private String patientDob;
    private Long  facilityId;
    private Long readingProvidorId;
    private Long orderingProvidorId;
    private LocalDate dateRangeStart;
    private LocalDate dateRangeEnd;


}
