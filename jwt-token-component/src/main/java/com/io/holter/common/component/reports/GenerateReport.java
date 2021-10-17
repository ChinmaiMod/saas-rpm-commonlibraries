
package com.io.holter.common.component.reports;

@lombok.Data
public class GenerateReport {
private java.util.UUID id;

    private String reportType;
    private java.util.UUID facilityId;
    private String tzSerial;
    private Integer studyId;
    private java.util.List<Strip> strips ;
    private com.io.holter.common.component.reports.HeartRateTrend heartRateTrend;
    private java.util.List arrhythmiaData ;
    private com.io.holter.common.component.reports.VentricularEctopy ventricularEctopy;
    private String comment;
    private String timestamp;


}
