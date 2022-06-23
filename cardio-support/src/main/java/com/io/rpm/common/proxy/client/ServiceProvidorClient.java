package com.io.rpm.common.proxy.client;

import com.io.rpm.common.component.ProposalDto;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "serviceprovider-service")
@RefreshScope
public interface ServiceProvidorClient {
    @GetMapping("/praposal/{id}")
    ProposalDto getQuoteById(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id);

}
