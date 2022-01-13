package com.subhankar.repository;

import com.subhankar.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin("*")
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByEmployeeName(String employeeName);

    Employee findByEmployeeCode(Long employeeCode);

    @Query("SELECT e from Employee e WHERE e.employeeName LIKE %?1%" +
            "OR e.employeeCode LIKE %?1%" +
            "OR e.employeeRole LIKE %?1%" +
            "OR e.employeeContactNumber LIKE %?1%" +
            "OR e.employeeCurrentAddress LIKE %?1%" +
            "OR e.employeePostalAddress LIKE %?1%" +
            "OR DATE_FORMAT(e.employeeDOB, '%d-%m-%Y') like %?1%" +
            "OR DATE_FORMAT(e.employeeJoingDate, '%d-%m-%Y') LIKE %?1%" +
            "OR DATE_FORMAT(e.employeeLastWorkingDate, '%d-%m-%Y') LIKE %?1%" +
            "OR e.employeeUID LIKE %?1%" +
            "OR e.employeePanCardNumber LIKE %?1%" +
            "OR e.employeeGender LIKE %?1%" +
            "OR e.employeeEducationInstitueName LIKE %?1%" +
            "OR e.employeeEducationPassoutYear LIKE %?1%" +
            "OR e.employeeHighestEducationMarks LIKE %?1%" +
            "OR e.employeeParentName LIKE %?1%" +
            "OR e.employeeParentContactNumber LIKE %?1%" +
            "OR e.employeeLastWithdrawnSalary LIKE %?1%" +
            "OR e.employeeEmailId LIKE %?1%" +
            "OR e.employeePassword LIKE %?1%")
    List<Employee> getDataByAnyInput(String keyword);


    Employee findByEmployeeEmailId(String employeeEmailId);
}
