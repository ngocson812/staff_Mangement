package com.example.staffmanagement.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Error {
    private Date date;
    private String detail;
    private String message;
}
