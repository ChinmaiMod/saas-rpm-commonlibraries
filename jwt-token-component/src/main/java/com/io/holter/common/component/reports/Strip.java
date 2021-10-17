
package com.io.holter.common.component.reports;

@lombok.Data
public class Strip {

    private String id;
    private String deviceClassification;
    private String userClassification;
    private String eventId;
    private Integer studyId;
    private String enrollmentId;
    private String facilityId;
    private Integer timeBase;
    private Integer gain;
    private String startTime;
    private String endTime;
    private Integer stripNumber;
    private String comment;
    private String createdBy;
    private com.io.holter.common.component.reports.DisplayedLeads displayedLeads;
    private com.io.holter.common.component.reports.InvertedChannels invertedChannels;
    private String sequenceLead;
    private com.io.holter.common.component.reports.Measurements measurements;
    private String eventClassification;


}
