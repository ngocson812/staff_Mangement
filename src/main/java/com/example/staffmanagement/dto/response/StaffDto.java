package com.example.staffmanagement.dto.response;

import com.example.staffmanagement.model.Staff;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class StaffDto {
    private Long id;
    @NotBlank(message = "code must not be empty")
    private String code;
    @NotBlank(message = "name must not be empty")
    private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private String homeTown;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDate dateStartWork;
    private boolean deleted;

    public StaffDto(Staff source) {
        BeanUtils.copyProperties(source,this);
    }
}
