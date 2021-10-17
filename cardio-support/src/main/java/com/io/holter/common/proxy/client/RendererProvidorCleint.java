package com.io.holter.common.proxy.client;

import com.io.holter.common.dto.RendorProvidorDto;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "client-service")
@RibbonClient(name = "client-service")
public interface RendererProvidorCleint {


}
