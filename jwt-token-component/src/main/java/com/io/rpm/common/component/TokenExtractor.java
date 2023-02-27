package com.io.rpm.common.component;

import org.springframework.http.server.reactive.ServerHttpRequest;


public interface TokenExtractor {

    String extract(ServerHttpRequest request);

    String extract(String header);

}
