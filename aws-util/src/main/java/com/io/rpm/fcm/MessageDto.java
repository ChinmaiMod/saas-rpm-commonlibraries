package com.io.rpm.fcm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private String title;
    private String message;
    private String topic;
    private String token;
    private List<String> tokens;
    private Map<String, String> data;
    private String image;
}
