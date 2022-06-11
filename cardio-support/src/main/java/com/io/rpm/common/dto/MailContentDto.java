package com.io.rpm.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MailContentDto {

    private List<String> to;

    private String subject;

    private String body;

    private String fromEmail;

    private String bcc;

    private String cc;

}
