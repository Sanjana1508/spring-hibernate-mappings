package com.oneToOne.mapping.service;

import com.oneToOne.mapping.entity.Account;

import java.util.List;

public interface AccountService {

    public List<Account> findAll();

    public Account findById(int theId);

    public  void save(Account account);

    public void deleteById(int theId);
}
