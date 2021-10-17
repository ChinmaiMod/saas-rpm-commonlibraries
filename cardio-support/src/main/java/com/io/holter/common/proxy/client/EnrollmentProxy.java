package com.io.holter.common.proxy.client;

import com.io.holter.common.dto.EnrollmentDto;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "client-service")
@RibbonClient(name = "client-service")
public interface EnrollmentProxy {


    @GetMapping("/enrolement/study/{studyId}")
    ResponseEntity<EnrollmentDto> getEnrollemntByStudyId(@PathVariable Long studyId);
}
