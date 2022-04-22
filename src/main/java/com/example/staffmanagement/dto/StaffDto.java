package com.example.staffmanagement.dto;

import com.example.staffmanagement.model.Staff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class StaffDto {
    private Long id;
    @NotBlank(message = "Khong dc de trong")
    private String code;
    @NotBlank(message = "Khong dc de trong")
    private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private String homeTown;
    private LocalDate dateStartWork;
    private boolean deleted;

    public StaffDto(Staff source) {
        BeanUtils.copyProperties(source,this);
    }

    public StaffDto(Object o) {
    }
}
