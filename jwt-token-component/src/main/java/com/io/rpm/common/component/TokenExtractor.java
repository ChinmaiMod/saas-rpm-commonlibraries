package com.io.rpm.common.component;

import org.springframework.http.server.ServletServerHttpRequest;


public interface TokenExtractor {

    String extract(ServletServerHttpRequest request);

    String extract(String header);

}
