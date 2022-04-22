package com.example.staffmanagement.service;

import com.example.staffmanagement.dto.Search;
import com.example.staffmanagement.dto.StaffDto;
import com.example.staffmanagement.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IStaffService {
    Staff save(StaffDto staff);
    void deleteById(Long id);
    Page<StaffDto> search(Search search, Pageable pageable);
    Optional<Object> findById(Long id);
}
