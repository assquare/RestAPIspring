package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccounts() {
        List<Account> list = new ArrayList<>();
        accountRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Account getAccountById(int accountId) {
        Account obj = accountRepository.findById(accountId).get();
        return obj;
    }

    @Override
    public boolean addAccount(Account account) {
        accountRepository.save(account);
        return true;
    }

    @Override
    public void updateAccount(Account account) {
            accountRepository.save(account);
    }

    @Override
    public void deleteAccount(int accountId) {
            accountRepository.delete(getAccountById(accountId));
    }
}
