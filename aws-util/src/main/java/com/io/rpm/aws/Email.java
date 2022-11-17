package com.io.rpm.aws;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    private String from;
    private List<String> to;
    private List<String> cc;
    private List<String> bcc;
    private String subject;
    private String body;
}
