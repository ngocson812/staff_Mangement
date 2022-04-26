package com.example.staffmanagement.dto.response;

import lombok.Data;

@Data
public class FailedResponse {
    private int status;
    private String errorCode;
    private String errorDescription;

    public FailedResponse(int status, String errorCode, String errorDescription) {
        this.status = status;
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }
}
