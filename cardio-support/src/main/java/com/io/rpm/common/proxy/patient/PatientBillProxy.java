package com.io.rpm.common.proxy.patient;

import com.io.rpm.common.component.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@FeignClient(name = "patient-service")
public interface PatientBillProxy {
    @GetMapping("/generate/enrollment/bill")
    ResponseEntity<String> generateEnrollmentBill(@RequestHeader("Authorization") String bearerToken, @RequestParam Long patientId, @RequestParam Long serviceId);
}
