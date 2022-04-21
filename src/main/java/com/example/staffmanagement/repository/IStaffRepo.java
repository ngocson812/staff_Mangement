package com.example.staffmanagement.repository;

import com.example.staffmanagement.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStaffRepo extends JpaRepository<Staff, Integer> {
    void deleteById(Long id);
    Optional<Object> findById(Long id);
}
