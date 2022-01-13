package com.subhankar.controller;

import com.subhankar.exception.DuplicateRecord;
import com.subhankar.exception.EmployeeRecordNotFound;
import com.subhankar.model.Employee;
import com.subhankar.repository.EmployeeRepository;
import com.subhankar.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EmployeeController {
    /*
    Functionality-
SignUp
SignIn
Show All Data
Update Data
DeleteData
Get Data By Id
Get Data By Name
Get Data By Employee Code
Get Data By Using any Input
     */

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("/signUp")
    public Employee signUp(@Valid @RequestBody Employee employee){

          // return employeeService.signUp(employee);

        List<Employee> employees = employeeRepository.findAll();
        Employee thisEmployee=null;
        boolean flag=false;
        for (Employee e : employees)
        {
            if(employee.getEmployeeCode()==e.getEmployeeCode()
                    ||employee.getEmployeeContactNumber()==e.getEmployeeContactNumber()
                    ||employee.getEmployeePanCardNumber()==e.getEmployeePanCardNumber()){
                flag = true;
                throw new DuplicateRecord("User Already Exists");

            }

        }
        if (thisEmployee==null && flag==false){
                thisEmployee =employeeService.signUp(employee);
        }
        return thisEmployee;
    }

    @GetMapping("/signIn/")
    public Employee signIn(@RequestParam String employeeEmailId, @RequestParam String employeePassword){
        Employee thisEmployee = null;
        if(employeeRepository.findByEmployeeEmailId(employeeEmailId)==null)
        {
            throw new EmployeeRecordNotFound("No such User");
        }
        else{
            List<Employee> empList = employeeRepository.findAll();
           thisEmployee= employeeService.signIn(employeeEmailId,employeePassword, empList);
        }

        return thisEmployee;
    }

    @GetMapping("/getAllData")
    public List<Employee> showAllData(){
        return employeeService.showAllData();
    }

    @PutMapping("/updateData/{id}")
    public Employee updateData(@PathVariable Long id,@RequestBody Employee employee) throws EmployeeRecordNotFound {
        Employee emp = employeeRepository.findById(id).orElseThrow(()->new EmployeeRecordNotFound("ID does not Exist"));
        return employeeService.updateData(emp,employee);
    }
    @DeleteMapping("/deleteData/{id}")
    public String deleteData(@PathVariable Long id) throws EmployeeRecordNotFound {
        employeeRepository.findById(id).orElseThrow(()->new EmployeeRecordNotFound("ID does not Exist"));
        String output = null;
        if(employeeRepository.findById(id).isPresent())
        {

            output=employeeService.deleteData(id);
        }
        else{
            output="Employee by id "+id+" not found";
        }
        return output;
    }

    @GetMapping("/getDataById/{id}")
    public Employee getDataById(@PathVariable Long id) throws EmployeeRecordNotFound {
        employeeRepository.findById(id).orElseThrow(()->new EmployeeRecordNotFound("ID does not Exist"));
        return employeeService.getDataById(id);
    }

    @GetMapping("/search/findByEmployeeName/{employeeName}")
    public List<Employee> getDataByEmployeeName(@RequestParam String employeeName){
        return employeeService.getDataByEmployeeName(employeeName);
    }

    @GetMapping("/getDataByEmployeeName/{employeeCode}")
    public Employee getDataByEmployeeCode(@RequestParam Long employeeCode){
        return employeeService.getDataByEmployeeCode(employeeCode);
    }

    @GetMapping("/getDataByAnyInput/")
    public List<Employee> GetDataByAnyInput(@RequestParam String keyword){
        return employeeService.getDataByAnyInput(keyword);
    }



}
