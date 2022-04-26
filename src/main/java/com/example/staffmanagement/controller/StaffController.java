package com.example.staffmanagement.controller;

import com.example.staffmanagement.dto.request.Search;
import com.example.staffmanagement.dto.response.Message;
import com.example.staffmanagement.dto.response.StaffDto;
import com.example.staffmanagement.dto.response.SuccessResponse;
import com.example.staffmanagement.dto.response.SuccessResponsePage;
import com.example.staffmanagement.service.IStaffService;
import lombok.AllArgsConstructor;
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
        return new ResponseEntity<>(new SuccessResponse(1, staffService.save(staff)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(new SuccessResponse(1,staffService.findById(id)),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editById(@Valid @PathVariable("id") Long id, @RequestBody StaffDto staff) {
        return new ResponseEntity<>(new SuccessResponse(1,staffService.update(id, staff)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        staffService.deleteById(id);
        return new ResponseEntity<>(new Message(1,"Deleted"), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam(required = false) String code,
                                                 @RequestParam(required = false) String name,
                                                 @RequestParam("page") int page,
                                                 @RequestParam("size") int size) {
        Search s = new Search();
        s.setCode(code);
        s.setName(name);
        return new ResponseEntity<>(new SuccessResponsePage(1,staffService.count(s),staffService.search(s,page,size)), HttpStatus.OK);
    }
}

