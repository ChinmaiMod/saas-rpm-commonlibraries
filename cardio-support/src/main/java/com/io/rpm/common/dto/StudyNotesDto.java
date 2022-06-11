package com.io.rpm.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudyNotesDto {
    private String fullName;
    private String  timestamp;
    private String note;
}
