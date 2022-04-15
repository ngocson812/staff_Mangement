package com.example.staffmanagement.service;

import com.example.staffmanagement.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IStaffService {
    Page<Staff> findAllStaff(Pageable pageable);
    void createStaff(Staff staff);
    Optional<Staff> findStaffById(Integer id);
    void deleteStaffById(Integer id);
    Page<Staff> search(Pageable pageable, String keyword);
}
