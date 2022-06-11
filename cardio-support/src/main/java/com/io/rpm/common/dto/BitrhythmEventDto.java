package com.io.rpm.common.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BitrhythmEventDto {
    private String id;
    private String type;
    private String enrollmentId;
    private String facilityId;
    private float itemNumber;
    private String timestamp;
    private float completed;

    private Date createdAt;
    private Date updatedAt;

    private String deviceId;

    private float sequence;
    private float sample;

    private float firstSequence;
    private float ecgCount;

    private String rhythm;

    private String comment;

    private String eventType;
    private String userClassification;

    private Long studyId;
    private float itemCount;
    private String studyStartDate;
    private String studyEndDate;
    private String studyIndication;
    private String studyNotes;
    private String studyState;
    private String studyType;
    private float reportCount;
    private String patientName;
    private String patientId;
    private String patientDob;
    private String patientGender;
    private String patientPhoneNumber;
    private String patientAddress;
    private String patientNotes;
    private String physicianName;
    private String physicianPhoneNumber;
    private String physicianFacility;
    private String physicianEmail;
    private String physicianAddress;
    private String physicianNotes;
    private String enrollmentDeviceId;
    private String tzSerial;
    private String deviceEnrollmentId;
    private String enrollmentStartTime;


}
