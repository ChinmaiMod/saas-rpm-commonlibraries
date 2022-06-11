package com.io.rpm.common.dto;

import com.io.rpm.common.component.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RendorProvidorDto {
    private Long id;
    private String degre;
    private String taxonomyCode;
    private String speciality;
    private String providerInitial;
    private String ssn;
    private String type;
    private String pager;
    private String printName;
    private String primaryServiceLocation;
    private String language;
    private String networkAffiliation;
    private String jobTitle;
    private String notes;
    private String npi;
    List<RendererProviderLabelDto> labels;
    private List<StateLiceneDto> stateLicenses;
    private List<FacilityDto> facilities;
    private UserDto user;
    private String fax;
    private String address2;
    private String zipCode;
    private String countryCode;


}
