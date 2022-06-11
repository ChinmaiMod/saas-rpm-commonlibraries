package com.io.rpm.common.component;

@lombok.Data
public class ErrorLogsDto {
    private java.util.UUID id;
    private java.util.UUID deviceId;

    @com.fasterxml.jackson.annotation.JsonProperty("fileLocation")
    private String fileLocation;
    @com.fasterxml.jackson.annotation.JsonProperty("receivedAt")
    private String receivedAt;
    @com.fasterxml.jackson.annotation.JsonProperty("createdAt")
    private String createdAt;
    @com.fasterxml.jackson.annotation.JsonProperty("updatedAt")
    private String updatedAt;
}
