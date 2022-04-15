package com.example.staffmanagement.service.impl;

import com.example.staffmanagement.model.Staff;
import com.example.staffmanagement.repository.IStaffRepo;
import com.example.staffmanagement.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StaffService implements IStaffService {

    @Autowired
    IStaffRepo staffRepo;

    @Override
    public Page<Staff> findAllStaff(Pageable pageable) {
        return staffRepo.findAll(pageable);
    }

    @Override
    public void createStaff(Staff staff) {
        staffRepo.save(staff);
    }

    @Override
    public Optional<Staff> findStaffById(Integer id) {
        return staffRepo.findById(id);
    }

    @Override
    public void deleteStaffById(Integer id) {
        staffRepo.deleteById(id);
    }

    @Override
    public Page<Staff> search(Pageable pageable, String keyword) {
        if (keyword != null){
            return staffRepo.search(pageable, keyword);
        }
        return staffRepo.findAll(pageable);
    }
}
