package com.io.holter.common.dto;

import com.io.holter.common.component.ClientDeviceDto;
import com.io.holter.common.component.ClientDto;
import com.io.holter.common.component.DeviceDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
public class EnrollmentDto {
    public EnrollmentDto(){}
    private Long id;
    private FacilityDto facility;
    private String firstEnrolType;
    private Long firstEnrolDuration;
    private PrimaryIndicationDto firstEnrolPrimaryIndication;
    private String secondEnrolType;
    private Long secondEnrolDuration;
    private PrimaryIndicationDto secondEnrolPrimaryIndication;
    private PatientDto patient;
    private RendorProvidorDto orderingProvider;
    private RendorProvidorDto readingProvider;
    private RefferProviderDto externalProvider;
    private String comments;
    private Boolean verified;
    private String status;
    private Long studyId;
    private ClientDto client;
    private ClientDeviceDto device;
    private Boolean hasPaceMaker;
    private Boolean hasICD;
    private Boolean showInsurance;
    private String EMRPatientId;
    private LocalDate enrollmentDate;
    private String bitrhythmEnrollmentId;
    private Date studyStartDate;
    private Date studyEndDate;
}
