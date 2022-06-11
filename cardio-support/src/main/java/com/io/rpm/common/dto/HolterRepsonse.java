package com.io.rpm.common.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HolterRepsonse {
    private String status;
    private String message;

    public static  HolterRepsonse toFailedResponse(String message){
        return HolterRepsonse.builder().status("FAILED").message(message).build();
    }
    public static HolterRepsonse toSuccessResponse(String message){
        return HolterRepsonse.builder().status("SUCCESS").message(message).build();
    }
}
