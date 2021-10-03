package com.oneToMany.mapping.service;

import com.oneToMany.mapping.dao.TransactionRepository;
import com.oneToMany.mapping.entity.Customer;
import com.oneToMany.mapping.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements  TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction findById(int theId) {
        Optional<Transaction> foundTransaction = transactionRepository.findById(theId);
        Transaction transaction=null;
        if(foundTransaction.isPresent()){
            transaction=foundTransaction.get();
        }
        return transaction;
    }

    @Override
    public void save(Transaction theTransaction) {
        transactionRepository.save(theTransaction);
    }

    @Override
    public void deleteById(int theId) {
        transactionRepository.deleteById(theId);
    }
}
