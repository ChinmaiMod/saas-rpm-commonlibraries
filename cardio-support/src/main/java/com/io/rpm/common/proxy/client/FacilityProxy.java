//package com.io.rpm.common.proxy.client;
//
//import com.io.rpm.common.dto.FacilityDto;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestHeader;
//
//import java.util.List;
//
//@FeignClient(name = "client-service",)
//public interface FacilityProxy {
//    @GetMapping( "/facility/{id}")
//    FacilityDto getFacilityById(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id);
//    @GetMapping("/facility/list/sort/{clientId}")
//    public List<FacilityDto> getFacilitiesByClientIdSort(@RequestHeader("Authorization") String bearerToken, @PathVariable Long clientId);
//
//}
