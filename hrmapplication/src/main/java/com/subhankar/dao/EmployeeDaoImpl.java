package com.subhankar.dao;

import com.subhankar.exception.DuplicateRecord;
import com.subhankar.exception.EmployeeRecordNotFound;
import com.subhankar.exception.InvalidLoginCredentials;
import com.subhankar.model.Employee;
import com.subhankar.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;
@CrossOrigin("*")
@Component
public class EmployeeDaoImpl implements EmployeeDao{

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee signUp(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee signIn(String employeeEmailId, String employeePassword, List<Employee> empList) {

        Employee thisEmployee = null;
        for(Employee e:empList){
            if (e.getEmployeeEmailId().equals(employeeEmailId) && e.getEmployeePassword().equals(employeePassword))
            {
                thisEmployee=e;
            }


        }
        if(thisEmployee==null)
        {
            throw new InvalidLoginCredentials("username or password is incorrect");
        }
        return thisEmployee;
    }

    @Override
    public List<Employee> showAllData() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateData(Employee thisEmployee, Employee employee) {

        thisEmployee.setEmployeeCode(employee.getEmployeeCode());
        thisEmployee.setEmployeeRole(employee.getEmployeeRole());
        thisEmployee.setEmployeeName(employee.getEmployeeName());
        thisEmployee.setEmployeeContactNumber(employee.getEmployeeContactNumber());
        thisEmployee.setEmployeeCurrentAddress(employee.getEmployeeCurrentAddress());
        thisEmployee.setEmployeePostalAddress(employee.getEmployeePostalAddress());
        thisEmployee.setEmployeeUID(employee.getEmployeeUID());
        thisEmployee.setEmployeePanCardNumber(employee.getEmployeePanCardNumber());
        thisEmployee.setEmployeeDOB(employee.getEmployeeDOB());
        thisEmployee.setEmployeeJoingDate(employee.getEmployeeJoingDate());
        thisEmployee.setEmployeeLastWorkingDate(employee.getEmployeeLastWorkingDate());
        thisEmployee.setEmployeeGender(employee.getEmployeeGender());
        thisEmployee.setEmployeeEducationInstitueName(employee.getEmployeeEducationInstitueName());
        thisEmployee.setEmployeeHighestEducation(employee.getEmployeeHighestEducation());
        thisEmployee.setEmployeeEducationPassoutYear(employee.getEmployeeEducationPassoutYear());
        thisEmployee.setEmployeeHighestEducationMarks(employee.getEmployeeHighestEducationMarks());
        thisEmployee.setEmployeeParentName(employee.getEmployeeParentName());
        thisEmployee.setEmployeeParentContactNumber(employee.getEmployeeParentContactNumber());
        thisEmployee.setEmployeeLastWithdrawnSalary(employee.getEmployeeLastWithdrawnSalary());
        thisEmployee.setEmployeeEmailId(employee.getEmployeeEmailId());
        thisEmployee.setEmployeePassword(employee.getEmployeePassword());
        employeeRepository.save(thisEmployee);
        return thisEmployee;
    }

    @Override
    public String deleteData(Long id) {
        String output=null;

            employeeRepository.deleteById(id);
            output="Employee Deleted Successfully";

        return output;
    }

    @Override
    public Employee getDataById(Long id) {
        //Employee thisEmployee = null;
        Employee emp = employeeRepository.findById(id).get();
//        if(emp.isPresent())
//        {
//            thisEmployee=emp.get();
//        }
        return emp;
    }

    @Override
    public List<Employee> getDataByEmployeeName(String employeeName) {
        return employeeRepository.findByEmployeeName(employeeName);
    }

    @Override
    public Employee getDataByEmployeeCode(Long employeeCode) {
        return employeeRepository.findByEmployeeCode(employeeCode);
    }

    @Override
    public List<Employee> getDataByAnyInput(String keyword) {

        return employeeRepository.getDataByAnyInput(keyword);
    }
}
