package com.example.staffmanagement.service;

import com.example.staffmanagement.dto.request.Search;
import com.example.staffmanagement.dto.response.StaffDto;
import org.springframework.data.domain.Page;

public interface IStaffService {
    StaffDto save(StaffDto staff);
    void deleteById(Long id);
    Page<StaffDto> search(Search search,int page, int size);
    StaffDto findById(Long id);
    StaffDto update(Long id, StaffDto staffDto);
    long count(Search search);
}
