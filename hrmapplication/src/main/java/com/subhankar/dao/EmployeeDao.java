package com.subhankar.dao;

import com.subhankar.model.Employee;

import java.util.List;

public interface EmployeeDao {

    public Employee signUp(Employee employee);

    public Employee signIn(String employeeEmailId, String employeePassword, List<Employee> empList);

    public List<Employee> showAllData();

    public Employee updateData(Employee emp, Employee employee);

    public String deleteData(Long id);

    public Employee getDataById(Long id);

    public List<Employee> getDataByEmployeeName(String employeeName);

    public Employee getDataByEmployeeCode(Long employeeCode);

    public List<Employee> getDataByAnyInput(String keyword);
}
