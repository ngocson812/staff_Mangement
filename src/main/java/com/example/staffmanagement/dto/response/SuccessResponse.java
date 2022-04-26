package com.example.staffmanagement.dto.response;

import lombok.Data;

@Data
public class SuccessResponse {
    private int status;
    private StaffDto data;

    public SuccessResponse(int status, StaffDto data) {
        this.status = status;
        this.data = data;
    }
}
