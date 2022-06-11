package com.io.rpm.common.component.reports;

@lombok.Data
public class DataValue {

    private String id;
    private String name;
    private String stripId;
    private String facilityId;
    private Integer startSampleOffset;
    private Integer endSampleOffset;
    private String startTime;
    private String endTime;
}
