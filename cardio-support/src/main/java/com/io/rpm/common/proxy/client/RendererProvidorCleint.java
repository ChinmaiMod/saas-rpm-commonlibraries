package com.io.rpm.common.proxy.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "client-service")
@RibbonClient(name = "client-service")
public interface RendererProvidorCleint {


}
