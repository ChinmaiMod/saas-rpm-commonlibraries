package com.io.rpm.common.component;


import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
public class DeviceDto {

@com.fasterxml.jackson.annotation.JsonProperty("firmwareVersion")
private String firmwareVersion;
@com.fasterxml.jackson.annotation.JsonProperty("gtin")
private String gtin;
@com.fasterxml.jackson.annotation.JsonProperty("iccid")
private String iccid;
@com.fasterxml.jackson.annotation.JsonProperty("imei")
private String imei;
@com.fasterxml.jackson.annotation.JsonProperty("manufacturingSerial")
private String manufacturingSerial;
@com.fasterxml.jackson.annotation.JsonProperty("pcbPartNumber")
private String pcbPartNumber;
@com.fasterxml.jackson.annotation.JsonProperty("tzSerial")
private String tzSerial;
@com.fasterxml.jackson.annotation.JsonProperty("forwardingMode")
private String forwardingMode;
@com.fasterxml.jackson.annotation.JsonProperty("forwardingUrl")
private String forwardingUrl;
@com.fasterxml.jackson.annotation.JsonProperty("deviceType")
private String deviceType;
@com.fasterxml.jackson.annotation.JsonProperty("availableForStudy")
private boolean availableForStudy;

}