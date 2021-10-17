package com.io.holter.common.dto;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class PrimaryIndicationDto {
    private Long id;
    private String value;
}
