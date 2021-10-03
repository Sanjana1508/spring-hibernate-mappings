package com.oneToMany.mapping.service;

import com.oneToMany.mapping.dao.CustomerRepository;
import com.oneToMany.mapping.dao.TransactionRepository;
import com.oneToMany.mapping.entity.Customer;
import com.oneToMany.mapping.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements  CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int theId) {
        Optional<Customer> foundCustomer = customerRepository.findById(theId);
        Customer customer=null;
        if(foundCustomer.isPresent()){
            customer=foundCustomer.get();
        }
        return customer;
    }

    @Override
    public void save(Customer theCustomer) {

        customerRepository.save(theCustomer);

    }

    @Override
    public void deleteById(int theId) {

        customerRepository.deleteById(theId);
    }
}
