package com.io.holter.common.component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {
    private Long id;
    private String name;
    private String contactNo;
    private String countryCode;
    private String email;
    private String type;
}
