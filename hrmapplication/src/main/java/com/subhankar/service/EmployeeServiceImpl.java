package com.subhankar.service;

import com.subhankar.dao.EmployeeDao;
import com.subhankar.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin("http://localhost:3000/")
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee signUp(Employee employee) {
        return employeeDao.signUp(employee);
    }

    @Override
    public Employee signIn(String employeeEmailId, String employeePassword, List<Employee> empList) {
        return employeeDao.signIn(employeeEmailId,employeePassword, empList);
    }

    @Override
    public List<Employee> showAllData() {
        return employeeDao.showAllData();
    }

    @Override
    public Employee updateData(Employee emp, Employee employee) {
        return employeeDao.updateData(emp,employee);
    }

    @Override
    public String deleteData(Long id) {
        return employeeDao.deleteData(id);
    }

    @Override
    public Employee getDataById(Long id) {
        return employeeDao.getDataById(id);
    }

    @Override
    public List<Employee> getDataByEmployeeName(String employeeName) {
        return employeeDao.getDataByEmployeeName(employeeName);
    }

    @Override
    public Employee getDataByEmployeeCode(Long employeeCode) {
        return employeeDao.getDataByEmployeeCode(employeeCode);
    }

    @Override
    public List<Employee> getDataByAnyInput(String keyword) {
        return employeeDao.getDataByAnyInput(keyword);
    }
}
