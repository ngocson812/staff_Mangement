package com.example.staffmanagement.model;

import com.example.staffmanagement.dto.response.StaffDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Staff{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private String homeTown;
    private LocalDate dateStartWork;
    private boolean deleted;

    public Staff(StaffDto source) {
        BeanUtils.copyProperties(source,this);
    }

    public Staff() {
    }

    public void update(StaffDto source) {
        BeanUtils.copyProperties(source,this,"code");
    }
}
