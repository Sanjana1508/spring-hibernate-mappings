package com.oneToOne.mapping.controller;

import com.oneToOne.mapping.entity.Account;
import com.oneToOne.mapping.entity.Employee;
import com.oneToOne.mapping.service.AccountService;
import com.oneToOne.mapping.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){

        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        return employeeService.findById(employeeId);
    }

    @PostMapping("/employees")
    public void createEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
    }

    @PutMapping("/employees")
    public void updateEmployee(@RequestBody Employee employee){
       employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteById(@PathVariable int employeeId){

        employeeService.deleteById(employeeId);
    }
}
