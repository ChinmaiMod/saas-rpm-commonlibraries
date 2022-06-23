package com.io.rpm.common.proxy.client;

import com.io.rpm.common.component.ClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
@FeignClient(name = "client-service")
public interface ClientProxy {
    @GetMapping("/internalclient/{clientId}")
    ClientDto getClientById(@RequestHeader("Authorization") String bearerToken, @PathVariable Long clientId);

}
