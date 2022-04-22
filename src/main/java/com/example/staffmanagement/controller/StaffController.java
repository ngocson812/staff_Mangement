package com.example.staffmanagement.controller;

import com.example.staffmanagement.dto.Search;
import com.example.staffmanagement.dto.StaffDto;
import com.example.staffmanagement.model.Staff;
import com.example.staffmanagement.service.IStaffService;
import lombok.AllArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Transactional
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/staffs")
public class StaffController {

    private IStaffService staffService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody StaffDto staff) {
        return new ResponseEntity<>(staffService.save(staff), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(staffService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Staff not found")), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editById(@Valid @PathVariable Long id, @RequestBody StaffDto staff) {
        staff.setId(id);
        return new ResponseEntity<>(staffService.save(staff), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        staffService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Staff not found"));
        staffService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<StaffDto>> search(@RequestParam(required = false) String code,
                                                 @RequestParam(required = false) String name, Pageable pageable) {
        Search s = new Search();
        s.setCode(code);
        s.setName(name);
        return new ResponseEntity<>(staffService.search(s,pageable), HttpStatus.OK);
    }
}

