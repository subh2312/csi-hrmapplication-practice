package com.subhankar.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Data
@Table(name = "employee")
//@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin("*")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "id")
    @NotNull
    private long id;//[Primary Key]- Not Null
    @Column(name = "employee_role")
    @NotNull
    private String employeeRole;
    @Column(name = "employee_code")
    @NotNull
    private long employeeCode;//[Unique Key]- Not Null
    @Column(name = "employee_name")
    @Pattern(regexp = "[A-Za-z]", message = "Employee Name Should not contain special character")
    @NotNull
    private String employeeName;
    @Column(name = "employee_contact_number")//[Employee Name Should not contain special character]- Not Null
    @NotNull
    private long employeeContactNumber;//[Unique Key]- Not Null
    @Column(name = "employee_current_address")
    @NotNull
    private String employeeCurrentAddress;//- Not Null
    @Column(name = "employee_permanent_address")
    @NotNull
    private String employeePostalAddress;//- Not Null
    @Column(name = "employee_uid")
    @NotNull
    @Pattern(regexp = "(^${12})")
    private long employeeUID;//[Unique Key][Employee UID must be 12 Digits]- Not Null
    @Column(name = "employee_pan_card")
    @NotNull
    @Pattern(regexp = "(^${10})")
    private String employeePanCardNumber;//[Unique Key]- Not Null
    @Column(name = "employee_dob")
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date employeeDOB;//[dd-MM-yyyy] Not Null
    @Column(name = "employee_joining_date")
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
    @Temporal(TemporalType.DATE)
    private Date employeeJoingDate;//[dd-MM-yyyy]
    @Column(name = "employee_last_working_date")
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
    @Temporal(TemporalType.DATE)
    private Date employeeLastWorkingDate;//[dd-MM-yyyy]
    @Column(name = "employee_gender")
    @NotNull
    private String employeeGender;//- Not Null
    @Column(name = "employee_education_institite_name")
    @NotNull
    private String employeeEducationInstitueName;//-Not Null
    @Column(name = "employee_highest_education")
    @NotNull
    private String employeeHighestEducation;//- Not Null
    @Column(name = "employee_education_passout_year")
    @NotNull
    private int employeeEducationPassoutYear;//- Not Null
    @Column(name = "employee_highest_education_marks")
    @NotNull
    private double employeeHighestEducationMarks;//- Not Null
    @Column(name = "employee_parent_name")
    @NotNull
    @Pattern(regexp = "^((?=[A-Za-z])(?![_\\-]).)*$", message = "Employee Name Should not contain special character")
    private String employeeParentName;//[Employee Name Should not contain special character]- Not Null
    @Column(name = "employee_parent_contact_number")
    @NotNull
    private long employeeParentContactNumber;//[Unique Key]- Not Null
    @Column(name = "employee_last_withdrawn_salary")
    private double employeeLastWithdrawnSalary;
    @Column(name = "employee_email_id")
    @NotNull
    @Pattern(regexp = "^(.+)@(.+$)", message = "Employee Email must be valid with @ and . ")
    private String employeeEmailId;//[Employee Email must be valid with @ and .]- Not Null
    @Column(name = "employee_password" )
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
    message = "Minimum eight characters, at least one uppercase letter, one lowercase letter, " +
            "one number and one special character")
    @NotNull
    private String employeePassword;//[Employee Password Should contain special character and min length 8]- Not Null

    public Employee(long employeeCode, String employeeRole,String employeeName, long employeeContactNumber, String employeeCurrentAddress, String employeePostalAddress, long employeeUID, String employeePanCardNumber, Date employeeDOB, Date employeeJoingDate, Date employeeLastWorkingDate, String employeeGender, String employeeEducationInstitueName, String employeeHighestEducation, int employeeEducationPassoutYear, double employeeHighestEducationMarks, String employeeParentName, long employeeParentContactNumber, double employeeLastWithdrawnSalary, String employeeEmailId, String employeePassword) {
        this.employeeCode = employeeCode;
        this.employeeRole = employeeRole;
        this.employeeName = employeeName;
        this.employeeContactNumber = employeeContactNumber;
        this.employeeCurrentAddress = employeeCurrentAddress;
        this.employeePostalAddress = employeePostalAddress;
        this.employeeUID = employeeUID;
        this.employeePanCardNumber = employeePanCardNumber;
        this.employeeDOB = employeeDOB;
        this.employeeJoingDate = employeeJoingDate;
        this.employeeLastWorkingDate = employeeLastWorkingDate;
        this.employeeGender = employeeGender;
        this.employeeEducationInstitueName = employeeEducationInstitueName;
        this.employeeHighestEducation = employeeHighestEducation;
        this.employeeEducationPassoutYear = employeeEducationPassoutYear;
        this.employeeHighestEducationMarks = employeeHighestEducationMarks;
        this.employeeParentName = employeeParentName;
        this.employeeParentContactNumber = employeeParentContactNumber;
        this.employeeLastWithdrawnSalary = employeeLastWithdrawnSalary;
        this.employeeEmailId = employeeEmailId;
        this.employeePassword = employeePassword;
    }
//
//    public Employee() {
//    }
}
