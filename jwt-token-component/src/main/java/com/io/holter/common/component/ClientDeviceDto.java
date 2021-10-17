package com.io.holter.common.component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDeviceDto {
	private Long id;
	private String tzSerial;
	private String barCode;
	private String firmwareVersion;
	private String iccid;
	private String gtin;
	private String imei;
	private String manufacturingSerial;
	private String pcbPartNumber;
	private String deviceType;
	private Boolean availableForStudy;
	private Boolean active;
	private ContractDto contractDto;
	private FacilityDto facility;
	private ProductDto product;
	private String bitrhythmDeviceId;
	private String bitrhythmFacilityId;
}
