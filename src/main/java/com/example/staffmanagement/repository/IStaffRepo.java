package com.example.staffmanagement.repository;

import com.example.staffmanagement.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IStaffRepo extends JpaRepository<Staff, Integer> {
    @Query("SELECT s FROM Staff s WHERE CONCAT(s.staffName,s.staffCode,s.dateStartWork) LIKE %?1%")
    Page<Staff> search(Pageable pageable, String keyword);
}
