package com.io.rpm.common.component;


@lombok.Data
public class FacilityConfigurationDto {

    private String facilityId;
    private String name;
    private Integer bradyRateChange;
    private Integer tachyRateChange;
    private Boolean detectPacemaker;
    private Integer reportPreTime;
    private Integer reportPostTime;
    private Integer minTimeBetweenEvents;
    private Boolean suppressNsrEvents;
    private Integer studyCompleteSleep;
    private Integer nagOnLeadOff;
    private Integer screenSleepTime;
    private Integer symptomDiaryEntries;
    private Integer activityDiaryEntries;
    private String symptomEntry1;
    private String symptomEntry2;
    private String symptomEntry3;
    private String symptomEntry4;
    private String symptomEntry5;
    private String symptomEntry6;
    private String symptomEntry7;
    private String symptomEntry8;
    private String symptomEntry9;
    private String symptomEntry10;
    private String activityEntry1;
    private String activityEntry2;
    private String activityEntry3;
    private String activityEntry4;
    private String activityEntry5;
    private String activityEntry6;
    private String activityEntry7;
    private String activityEntry8;
    private String activityEntry9;
    private String activityEntry10;
    private String topBanner;

}