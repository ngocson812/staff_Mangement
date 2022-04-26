package com.example.staffmanagement.dto.response;

import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class SuccessResponsePage {
    private int status;
    private long totalRecord;
    private Page<StaffDto> data;

    public SuccessResponsePage(int status, long totalRecord ,Page<StaffDto> search) {
        this.status = status;
        this.totalRecord = totalRecord;
        this.data = search;
    }
}
