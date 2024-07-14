package com.io.rpm.common.proxy.client;

import com.io.rpm.common.dto.EnrollmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "client-service", url="http://localhost:8088")
@FeignClient(name = "client-service", contextId="enrollment")
public interface EnrollmentProxy {

	//used in service-provider
    @GetMapping("/enrolement/study/{studyId}")
    ResponseEntity<EnrollmentDto> getEnrollemntByStudyId(@PathVariable Long studyId);
}
