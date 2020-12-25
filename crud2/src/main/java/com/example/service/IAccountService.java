package com.example.service;


import com.example.model.Account;

import java.util.List;

public interface IAccountService {

    List<Account> getAllAccounts();
    Account getAccountById(int accountId);
    boolean addAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(int accountIdId);

}
