package com.io.rpm.common.component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private String house;
    private String appartment;
    private String street;
    private String city;
    private String area;
    private String country;
    private String zipcode;
    private String type;
    private String addressLine1;
    private String addressLine2;
    private String countryCode1;
    private String countryCode2;
    private String phone1;
    private String phone2;
    private String state;
    private String notes;
}
