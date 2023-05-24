package com.io.rpm.common.proxy.client;

import com.io.rpm.common.component.DeviceDto;
import com.io.rpm.common.component.study.StudyDto;
import com.io.rpm.common.dto.BitrhythmEventDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient( name = "gateway-intregration-service",url = "http://15.207.253.86:8090/bitr/")
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

    @PostMapping("studies/startStudy")
    ResponseEntity<Object> startStudy(@RequestHeader("Authorization") String token, @RequestBody StudyDto.Request request);


    @GetMapping("/studies")
    ResponseEntity<List<StudyDto.Response>> getStudy(@RequestHeader("Authorization") String token);

    @GetMapping("/inboxItems/joined")
    ResponseEntity<List<BitrhythmEventDto>> getEvent(@RequestHeader("Authorization") String token);
}
