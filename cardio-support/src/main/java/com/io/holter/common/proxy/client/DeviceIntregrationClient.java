package com.io.holter.common.proxy.client;

import com.io.holter.common.component.DeviceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@FeignClient( name = "gateway-intregration-service",url = "http://65.1.169.141:8090/bitr/")
//@RibbonClient(name = "apiintregration-service")
public interface DeviceIntregrationClient {

    @GetMapping("devices")
      ResponseEntity<List<DeviceDto>> getDevices(@RequestHeader("Autharization") String token,

                                                 @RequestParam(required = false) UUID id,
                                                 @RequestParam(required = false) String operationalState,
                                                 @RequestParam(required = false) String gtin,
                                                 @RequestParam(required = false) String manufacturingSerial,
                                                 @RequestParam(required = false) String tzSerial
            , @RequestParam(required = false) String firmwareVersion
            , @RequestParam(required = false) String pcbPartNumber
            , @RequestParam(required = false) String imei
            , @RequestParam(required = false) String iccid
            , @RequestParam(required = false) UUID facilityId
            , @RequestParam(required = false) String forwardingUrl
            , @RequestParam(required = false) String deviceType
            , @RequestParam(required = false) Boolean availableForStudy
    );

}
