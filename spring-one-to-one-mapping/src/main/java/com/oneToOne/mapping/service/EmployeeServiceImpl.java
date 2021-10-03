package com.oneToOne.mapping.service;

import com.oneToOne.mapping.dao.AccountRepository;
import com.oneToOne.mapping.dao.EmployeeRepository;
import com.oneToOne.mapping.entity.Account;
import com.oneToOne.mapping.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int theId) {
        Optional<Employee> employeeFound= employeeRepository.findById(theId);
        Employee employee=null;
        if(employeeFound.isPresent()){
            employee = employeeFound.get();
        }
        return  employee;
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        Account account = employee.getAccount();
        accountRepository.save(account);
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        Account account = employeeRepository.findById(theId).get().getAccount();

        accountRepository.deleteById(account.getId());

        employeeRepository.deleteById(theId);
    }
}
