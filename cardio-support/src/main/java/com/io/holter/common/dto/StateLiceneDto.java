package com.io.holter.common.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class StateLiceneDto {
    private Long id;
    private String state;
    private String liecence;
    private LocalDate activateDate;
    private LocalDate termDate;
}
