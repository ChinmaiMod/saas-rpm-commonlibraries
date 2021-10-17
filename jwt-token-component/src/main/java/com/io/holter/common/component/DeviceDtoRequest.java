package com.io.holter.common.component;

public interface DeviceDtoRequest {


    @lombok.Data
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
    class GetResponse {
        private java.util.UUID id;
        private String gtin;
        private String manufacturingSerial;
        private String tzSerial;
        private String firmwareVersion;
        private String pcbPartNumber;
        private String imei;
        private String iccid;
        private String operationalState;
        private String pendingState;
        private String pendingFacilityId;
        private String forwardingMode;
        private String forwardingUrl;
        private String deviceType;
        private Boolean availableForStudy;
        private String createdBy;
        private String barcode;
        private String status;
        private String facilityId;
        private String facilityName;
        private String facilityForwardingUrl;
        private String forwardingDestination;
        private String facilityForwardingMode;
        private String pendingFacilityName;
        private String lastConnection;
        private String lastPatientEventTime;
        private Integer lastHttpStatus;
        private String lastResponseBody;
        private String connectionFirmwareVersion;
        private String updatedFirmwareVersion;
    }

    @lombok.Data
    class PatchDevices {
        private String id;
        private Properties properties;
    }

    @lombok.Data
    class Properties {
        private String facilityId;
        private String operationalState;
        private String pendingState;
        private String pendingFacilityId;
        private Boolean availableForStudy;
    }

    @lombok.Data
    class PatchDevicesResponse {
        private java.util.List<Common> success;
        private java.util.List<Failure> failure;
    }

    @lombok.Data
    class Failure extends Common {
        private Properties properties;
    }
@lombok.Data
    class Common {
        private String id;
        private String gtin;
        private String manufacturingSerial;
        private String tzSerial;
        private String firmwareVersion;
        private String pcbPartNumber;
        private String imei;
        private String iccid;
        private String operationalState;
        private String pendingState;
        private String pendingFacilityId;
        private String forwardingMode;
        private String forwardingUrl;
        private String deviceType;
        private Boolean availableForStudy;
        private String createdBy;
        private String facilityId;
    }

    @lombok.Data
    class PatchDevice {
        private java.util.UUID facilityId;
        private String operationalState;
        private String pendingState;
        private String pendingFacilityId;
        private Boolean availableForStudy;
    }

    @lombok.Data
    class PatchMultipleDevice {
        private java.util.UUID id;
        private String forwardingMode;
        private String forwardingUrl;
    }

    @lombok.Data
    class Setting {
        private java.util.UUID id;
        private String firmwareVersion;
        private String graphicsVersion;
    }


}