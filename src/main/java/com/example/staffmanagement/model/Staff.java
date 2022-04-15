package com.example.staffmanagement.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staffId;
    private String staffCode;
    private String staffName;
    private LocalDate dateOfBirth;
    private String gender;
    private String homeTown;
    private LocalDate dateStartWork;

    public Staff(int staffId, String staffCode, String staffName, LocalDate dateOfBirth, String gender, String homeTown, LocalDate dateStartWork) {
        this.staffId = staffId;
        this.staffCode = staffCode;
        this.staffName = staffName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.homeTown = homeTown;
        this.dateStartWork = dateStartWork;
    }

    public Staff() {

    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public LocalDate getDateStartWork() {
        return dateStartWork;
    }

    public void setDateStartWork(LocalDate dateStartWork) {
        this.dateStartWork = dateStartWork;
    }
}
