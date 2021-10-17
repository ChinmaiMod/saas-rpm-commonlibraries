package com.io.holter.common.component;

public interface EcgsDto {
    @lombok.Data
    class Ecg {
        private String id;
        private String enrollmentId;
        private Integer sequence;
        private Integer samplePeriod;
        private Integer avm;
        private String startTime;
        private String fileLocation;
        private Integer eventSample;
        private java.util.List<Lead> leads;
    }

    @lombok.Data
    class Lead {

        private String leadName;
        private Integer startSample;
        private Integer endSample;
        private Integer totalSamples;
        private java.util.List<Integer> data = null;

    }

    @lombok.Data
    class EcgsResponse {

        private String id;
        private String enrollmentId;
        private String deviceId;
        private String facilityId;
        private String userClassification;
        private Integer sample;
        private String sequence;
        private String timestamp;
        private Integer firstSequence;
        private Integer ecgCount;
        private Boolean completed;
        private String lockedAt;
        private String lockedBy;
        private Ecg ecg;
    }
}
