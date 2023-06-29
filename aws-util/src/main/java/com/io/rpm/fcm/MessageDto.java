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
    private Long senderId;
    private Long receiverId;
    private Integer serviceId;
    private List<String> tokens;
    private Map<String, String> data;
    private String image;
    private String senderName;
    private String recipientName;
    private int msgCount;
    // chat message dto
}
