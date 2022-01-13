package com.subhankar.dao.test;

import com.subhankar.controller.EmployeeController;
import com.subhankar.dao.EmployeeDaoImpl;
import com.subhankar.model.Employee;
import com.subhankar.repository.EmployeeRepository;
import com.subhankar.service.EmployeeService;
import org.apache.el.stream.Optional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeDaoImplTest {
    @Autowired
    EmployeeDaoImpl employeeDao;

    @MockBean
    EmployeeRepository employeeRepository;

    @Mock
    private EmployeeService employeeService;


    @Test
    public void getAllDataTest(){
        when(employeeDao.showAllData())
                .thenReturn(Stream.of(new Employee(7777,"employee","testEmployee",
                        999997788,"BBI","CTC",
                        123458910, "bdsp432p",new Date(2021-12-27),new Date(2021-12-27),
                        null,"Male","CVRCE",
                        "BE",2014,98,
                        "testParent",88776655,
                        50000,"abc@test.com","test@123"))
                        .collect(Collectors.toList()));
        Assert.assertEquals(1,employeeDao.showAllData().size());
    }



    @Test
    public void signUpTest(){
        Employee employee = new Employee(7777,"employee","testEmployee",
                        999997788,"BBI","CTC",
                        123458910, "bdsp432p",new Date(2021-12-27),new Date(2021-12-27),
                        null,"Male","CVRCE",
                        "BE",2014,98,
                        "testParent",88776655,
                        50000,"abc@test.com","test@123");

        employeeDao.signUp(employee);
        verify(employeeRepository, times(1)).save(employee);
    }


    @Test
    public void signInTest() {
        List<Employee> empList= new ArrayList<>();
        Employee employee = new Employee(7777,"employee","testEmployee",
                999997788,"BBI","CTC",
                123458910, "bdsp432p",new Date(2021-12-27),new Date(2021-12-27),
                null,"Male","CVRCE",
                "BE",2014,98,
                "testParent",88776655,
                50000,"abc@test.com","test@123");
    empList.add(employee);
        employeeDao.signUp(employee);
        verify(employeeRepository, times(1)).save(employee);
        Employee result = employeeDao.signIn(employee.getEmployeeEmailId(), employee.getEmployeePassword(), empList);
        Assert.assertTrue(employee.getEmployeeCode() == result.getEmployeeCode());
    }

    @Test
    public void deleteDataTest() {
        Employee employee = new Employee(7777,"employee","testEmployee",
                999997788,"BBI","CTC",
                123458910, "bdsp432p",new Date(2021-12-27),new Date(2021-12-27),
                null,"Male","CVRCE",
                "BE",2014,98,
                "testParent",88776655,
                50000,"abc@test.com","test@123");

        employeeDao.signUp(employee);
        verify(employeeRepository, times(1)).save(employee);
        String output = employeeDao.deleteData(employee.getId());
        Assert.assertTrue(output.equals("Employee Deleted Successfully"));
        Assert.assertEquals(0,employeeDao.showAllData().size());
    }

    @Test
    public void getDataByIdTest() {
        Employee employee = new Employee(7777,"employee","testEmployee",
                999997788,"BBI","CTC",
                123458910, "bdsp432p",new Date(2021-12-27),new Date(2021-12-27),
                null,"Male","CVRCE",
                "BE",2014,98,
                "testParent",88776655,
                50000,"abc@test.com","test@123");
        //employeeDao.signUp(employee);
        //verify(employeeRepository, times(1)).save(employee);
        when(employeeService.getDataById(anyLong())).thenReturn(employee);
//        Employee result = employeeDao.getDataById(employee.getId());
//        Assert.assertTrue(employee.getEmployeeCode() == result.getEmployeeCode());

    }

    @Test
    public void getDataByEmployeeNameTest() {
        Employee employee = new Employee(7777,"employee","testEmployee",
                999997788,"BBI","CTC",
                123458910, "bdsp432p",new Date(2021-12-27),new Date(2021-12-27),
                null,"Male","CVRCE",
                "BE",2014,98,
                "testParent",88776655,
                50000,"abc@test.com","test@123");

        employeeDao.signUp(employee);
        verify(employeeRepository, times(1)).save(employee);
        List<Employee> result = employeeDao.getDataByEmployeeName(employee.getEmployeeName());
        //Assert.assertEquals(1,employeeDao.showAllData().size());
        for(Employee e:result){
            Assert.assertTrue(e.getEmployeeCode()==employee.getEmployeeCode());
        }

    }

    @Test
    public void getDataByEmployeeCodeTest() {
        Employee employee = new Employee(7777,"employee","testEmployee",
                999997788,"BBI","CTC",
                123458910, "bdsp432p",new Date(2021-12-27),new Date(2021-12-27),
                null,"Male","CVRCE",
                "BE",2014,98,
                "testParent",88776655,
                50000,"abc@test.com","test@123");

//        employeeDao.signUp(employee);
//        verify(employeeRepository, times(1)).save(employee);
        //Assert.assertEquals(1,employeeDao.showAllData().size());
        when(employeeService.getDataByEmployeeCode(anyLong())).thenReturn(employee);
//        Employee result = employeeDao.getDataByEmployeeCode(employee.getEmployeeCode());
//        Assert.assertTrue(employee.getEmployeeName().equals(result.getEmployeeName()));
    }

    @Test
    public void getDataByAnyInputTest() {
        Employee employee = new Employee(7777,"employee","testEmployee",
                999997788,"BBI","CTC",
                123458910, "bdsp432p",new Date(2021-12-27),new Date(2021-12-27),
                null,"Male","CVRCE",
                "BE",2014,98,
                "testParent",88776655,
                50000,"abc@test.com","test@123");

        employeeDao.signUp(employee);
        verify(employeeRepository, times(1)).save(employee);
        List<Employee> result = employeeDao.getDataByAnyInput(employee.getEmployeePanCardNumber());
        for(Employee e:result){
            Assert.assertTrue(e.getEmployeeCode()==employee.getEmployeeCode());
        }
    }


}
