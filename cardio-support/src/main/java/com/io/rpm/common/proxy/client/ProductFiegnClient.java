package com.io.rpm.common.proxy.client;

import com.io.rpm.common.component.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "serviceprovider-service")
public interface ProductFiegnClient {

    @GetMapping("/{productId}")
    ProductDto getIndiviualProduct(@RequestHeader("Authorization") String bearerToken, @PathVariable Long productId);
}
