package com.io.rpm.common.component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
    private Long clientId;
    private String clientName;
    private String referralSource;
    private String industry;
    private String workPhone;
    private String mobilePhone;
    private String countryCode;
    private String fax;
    private String email;
    private String otherEmail;
    private String website;
    private String messenger;
    private String comment;
    private String responsiblePerson;
    private Boolean active;
    List<AddressDto> addresses;
    List<ContactDto> contacts;
}
