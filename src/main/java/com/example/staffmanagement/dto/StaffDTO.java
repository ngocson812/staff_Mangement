package com.example.staffmanagement.dto;

import com.example.staffmanagement.model.Staff;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class StaffDTO {
    private Long id;
    private String code;
    private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private String homeTown;
    private LocalDate dateStartWork;

    public StaffDTO(Staff source) {
        BeanUtils.copyProperties(source,this);
    }

    public StaffDTO(Object o) {
    }
}
