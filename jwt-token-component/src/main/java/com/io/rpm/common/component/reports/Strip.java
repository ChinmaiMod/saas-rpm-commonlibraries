
package com.io.rpm.common.component.reports;

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
    private DisplayedLeads displayedLeads;
    private InvertedChannels invertedChannels;
    private String sequenceLead;
    private Measurements measurements;
    private String eventClassification;


}
