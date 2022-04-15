package com.example.staffmanagement.controller;

import com.example.staffmanagement.model.Staff;
import com.example.staffmanagement.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    IStaffService staffService;

    @GetMapping
    public ResponseEntity<Page<Staff>> getAllStaff(@PageableDefault(size = 20) Pageable pageable) {
        return new ResponseEntity<>(staffService.findAllStaff(pageable), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createStaff(@RequestBody Staff staff) {
        staffService.createStaff(staff);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findStaffById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(staffService.findStaffById(id), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editStaffById(@PathVariable("id") Integer id, @RequestBody Staff staff) {
        staff.setStaffId(id);
        staffService.createStaff(staff);
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStaffById(@PathVariable("id") Integer id) {
        staffService.deleteStaffById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<?> search(@PathVariable("keyword") String keyword, Pageable pageable){
        return new ResponseEntity<>(staffService.search(pageable, keyword), HttpStatus.OK);
    }

}
