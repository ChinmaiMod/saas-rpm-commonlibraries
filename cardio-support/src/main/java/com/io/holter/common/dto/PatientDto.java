package com.io.holter.common.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@Data
public class PatientDto {
    private  Long id;
    private Long accountNo;
    private String lastName;
    private String firstName;
    private String middleName;
    private String sufix;
    private String mi;
    private String dob;
    private String sex;
    private String ssn;
    private String previousName;
    private String address;
    private String city;
    private String state;
    private String country;
    private String phone1;
    private String phone2;
    private String countryCode1;
    private String countryCode2;
    private String zipCode;
    private String email;
    private String lastAppt;
    private String emergencyContactNo;
    private String respParty;
    private String relation;
    private String acctBalance;
    private String ptBalance;
    private String nextAppt;
    private Long refferingProvider;
    private Long renderringProvider;
    private String martialStatus;
    private String language;
    private String race;
    private String ethinicity;
    private String releaseInfo;
    private String signDate;
    private String insurance;
    private Boolean archive;

    List<PatientLabelDto> labels;
    private String occupation;
    private Integer height;
    private Integer weight;
    private String bloodGroup;
    private String sexualOrientation;
    private String note;

    List<PatientContactDto> contacts;
    private String image;
    private Long clientId;
}
