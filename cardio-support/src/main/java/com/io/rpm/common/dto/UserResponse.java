package com.io.rpm.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface UserResponse {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class UserKeyResponse{
        private String fullName;
        private Long id;
    }
}
