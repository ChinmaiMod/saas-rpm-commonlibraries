package com.io.holter.common.component;

@lombok.Data
public class QrsExclusionReigonDto {

    private java.util.UUID enrollmentId;
    private java.util.UUID facilityId;
    private  String startTime;
    private String endTime;
}
