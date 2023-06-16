package com.io.rpm.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BitrhythmDeviceDto{
    public String id;
    public String gtin;
    public String manufacturingSerial;
    public String tzSerial;
    public String firmwareVersion;
    public String pcbPartNumber;
    public String imei;
    public String iccid;
    public String operationalState;
    public String pendingState;
    public String pendingFacilityId;
    public String forwardingMode;
    public String forwardingUrl;
    public String deviceType;
    public Boolean availableForStudy;
    public String createdBy;
    public String facilityId;
}