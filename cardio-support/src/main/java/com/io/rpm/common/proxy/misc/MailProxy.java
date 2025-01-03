package com.io.rpm.common.proxy.misc;

import com.io.rpm.common.dto.MailContentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "misc-service" )
    public interface MailProxy {

    @PostMapping("/sendEmail")
      ResponseEntity<String> sendEmail(@RequestHeader("Authorization") String bearerToken, @RequestBody MailContentDto contentDto);
}
