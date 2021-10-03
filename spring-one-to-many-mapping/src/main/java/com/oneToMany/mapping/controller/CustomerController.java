package com.oneToMany.mapping.controller;

import com.oneToMany.mapping.entity.Customer;
import com.oneToMany.mapping.entity.Transaction;
import com.oneToMany.mapping.service.CustomerService;
import com.oneToMany.mapping.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    public CustomerService customerService;


    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerService.findAll();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        return customerService.findById(customerId);
    }

    @PostMapping("/customers")
    public void createCustomer(@RequestBody Customer customer){
       customerService.save(customer);

    }

    @PutMapping("/customers")
    public void updateCustomer(@RequestBody Customer customer){

        customerService.save(customer);

    }

    @DeleteMapping("/customers/{customerId}")
    public void deleteById(@PathVariable int customerId){
        customerService.deleteById(customerId);
    }

}
