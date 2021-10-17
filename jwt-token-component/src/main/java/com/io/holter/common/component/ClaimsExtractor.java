package com.io.holter.common.component;


import io.jsonwebtoken.Claims;

public interface ClaimsExtractor {

    Claims extract(String token);

}
