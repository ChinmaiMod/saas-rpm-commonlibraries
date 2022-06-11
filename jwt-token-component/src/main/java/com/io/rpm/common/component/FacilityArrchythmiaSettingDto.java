package com.io.rpm.common.component;

@lombok.Data
public class FacilityArrchythmiaSettingDto {

    private java.util.UUID facilityId;
    private String name;
    private Integer tachyBpm;
    private Integer bradyBpm;
    private Integer pauseDuration;
    private Integer episodeDuration;
    private Integer hpFilter;
    private Integer lpFilter;
    private Integer notchFilter;
}
