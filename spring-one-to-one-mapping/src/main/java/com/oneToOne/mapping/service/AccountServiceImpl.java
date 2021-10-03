package com.oneToOne.mapping.service;

import com.oneToOne.mapping.dao.AccountRepository;
import com.oneToOne.mapping.entity.Account;
import com.oneToOne.mapping.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    @Transactional
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    @Transactional
    public Account findById(int theId) {
        Optional<Account> accountFound= accountRepository.findById(theId);
        Account account=null;
        if(accountFound.isPresent()){
            account = accountFound.get();
        }
        return  account;
    }

    @Override
    @Transactional
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        accountRepository.deleteById(theId);
    }
}
