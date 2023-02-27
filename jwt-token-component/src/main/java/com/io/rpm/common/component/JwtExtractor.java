package com.io.rpm.common.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;


import static org.apache.logging.log4j.util.Strings.isBlank;

@Component
public class JwtExtractor implements TokenExtractor {

    private final JwtSettings settings;
    private static final Logger logger = LoggerFactory.getLogger(JwtExtractor.class);
    @Autowired
    public JwtExtractor(JwtSettings settings) {
        this.settings = settings;
    }

    @Override
    public String extract(ServerHttpRequest request) {
        String  token= extract( request.getHeaders().getFirst(settings.getTokenHeader()));
        if(ObjectUtils.isEmpty(token)){
            token=request.getQueryParams().getFirst(settings.getTokenQueryParam());
        }
        logger.info("JwtExtractor {}",token);
        return token;
    }

    @Override
    public String extract(String header) {
        if (isBlank(header) || !header.startsWith(settings.getTokenPrefix().concat(" "))) {
            return null;
        }
        return header.substring(settings.getTokenPrefix().length() + 1);
    }


}
