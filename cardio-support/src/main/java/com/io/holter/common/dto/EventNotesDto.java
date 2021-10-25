package com.io.holter.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventNotesDto {

    private Long id;
    private String notes;
    private String type;
    private Long providerId;
    private String eventId;
    private UserResponse.UserKeyResponse createdBy;
    private UserResponse.UserKeyResponse provider;

}
