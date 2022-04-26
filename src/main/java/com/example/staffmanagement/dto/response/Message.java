package com.example.staffmanagement.dto.response;

import lombok.Data;

@Data
public class Message {
    private long status;
    private String mess;

    public Message(long status, String mess) {
        this.status = status;
        this.mess = mess;
    }
}
