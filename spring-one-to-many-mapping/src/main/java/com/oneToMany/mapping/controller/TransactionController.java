package com.oneToMany.mapping.controller;

import com.oneToMany.mapping.entity.Transaction;
import com.oneToMany.mapping.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions(){
        return transactionService.findAll();
    }

    @GetMapping("/transactions/{transactionId}")
    public Transaction getTransaction(@PathVariable int transactionId){
        return transactionService.findById(transactionId);
    }

    @PutMapping("/transactions")
    public void updateTransaction(@RequestBody Transaction transaction){
        transactionService.save(transaction);
    }

    @DeleteMapping("/transactions/{transactionId}")
    public void deleteTransaction(@PathVariable int transactionId){
        transactionService.deleteById(transactionId);
    }
}
