package com.example.staffmanagement.controller;

import com.example.staffmanagement.dto.Search;
import com.example.staffmanagement.dto.StaffDTO;
import com.example.staffmanagement.model.Staff;
import com.example.staffmanagement.service.IStaffService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@Transactional
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/staffs")
public class StaffController {

    private IStaffService staffService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Staff staff) {
        staffService.save(staff);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(staffService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editById(@PathVariable Long id, @RequestBody Staff staff) {
        staff.setId(id);
        staffService.save(staff);
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        staffService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<StaffDTO>> search(@RequestParam(required = false) String code,
                                    @RequestParam(required = false) String name, Pageable pageable) {
        Search s = new Search();
        s.setCode(code);
        s.setName(name);
        return new ResponseEntity<>(staffService.search(s,pageable), HttpStatus.OK);
    }
}

