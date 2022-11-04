package com.io.rpm.common.component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserConsentDto {
    private Long id;
    private Long userId;
    private String consentName;
    private Boolean accepted;
    private LocalDateTime createdDate;
}
