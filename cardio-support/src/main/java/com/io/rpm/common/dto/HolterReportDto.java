package com.io.rpm.common.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HolterReportDto {
    private Long id;
    private Boolean isSignedByReadingProvider;
    private Boolean isSignedByOrderingProvider;
    private Boolean reviewed;
    private String reportUrl;
    private Long reviewBy;
    private Long signByReadingProvider;
    private Long signByOrderingProvider;
    private UserResponse.UserKeyResponse signByReadingProviderResponse;
    private UserResponse.UserKeyResponse reviewByUser;
    private UserResponse.UserKeyResponse signByOrderingProviderResponse;
}
