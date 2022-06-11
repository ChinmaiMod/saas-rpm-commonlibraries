package com.io.rpm.common.component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDto {
    private Long id;
    private String companyName;
    private String address;
    private String contactPerson;
    private String contactPersonEmail;
    private String contactPersonMobil;
    private String companyPhone;
    private String companyFax;
    private String companyEmail;
    private String companyWebsite;
    private String countryCode;
}
