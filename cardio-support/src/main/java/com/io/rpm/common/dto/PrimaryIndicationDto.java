package com.io.rpm.common.dto;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class PrimaryIndicationDto {
    private Long id;
    private String value;
}
