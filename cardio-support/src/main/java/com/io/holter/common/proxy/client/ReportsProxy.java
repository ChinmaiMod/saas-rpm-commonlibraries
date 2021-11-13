package com.io.holter.common.proxy.client;

import com.io.holter.common.component.DeviceDto;
import com.io.holter.common.dto.BitrhythmReportDto;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "gateway")
@RibbonClient(name = "gateway")
public interface ReportsProxy {
    @GetMapping("/bitr/generatedReports")
    ResponseEntity<List<BitrhythmReportDto>> getBitrhytmReports(@RequestHeader("Authorization") String token, @RequestParam(name = "studyId") Long studyId);
}
