package com.oneToOne.mapping.controller;

import com.oneToOne.mapping.entity.Account;
import com.oneToOne.mapping.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public List<Account> getAccounts(){
        return accountService.findAll();
    }

    @GetMapping("/{accountId}")
    public Account getAccount(@PathVariable int accountId){
        return accountService.findById(accountId);
    }

    @PutMapping("/")
    public void updateAccount(@RequestBody Account account){
        accountService.save(account);
    }

    @DeleteMapping("/{accountId}")
    public void deleteAccount(@PathVariable int accountId){
        accountService.deleteById(accountId);
    }

}
