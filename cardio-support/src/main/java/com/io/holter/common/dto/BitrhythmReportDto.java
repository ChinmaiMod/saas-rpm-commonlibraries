package com.io.holter.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BitrhythmReportDto {
	
	public String id;
	private String reportType;
	private String tzSerial;
	private Long studyId;
	private Integer reportNumber;
	private String comment;
	private String timestamp;
	private HolterReportDto holterReport;

}
