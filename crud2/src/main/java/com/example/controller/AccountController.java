package com.example.controller;

import com.example.model.Account;
import com.example.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @GetMapping("account/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") Integer id) {
        Account account = accountService.getAccountById(id);
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }

    @GetMapping("accounts")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> list = accountService.getAllAccounts();
        return new ResponseEntity<List<Account>>(list, HttpStatus.OK);
    }

    @PostMapping("account")
    public ResponseEntity<Void> addAccount(@RequestBody Account account, UriComponentsBuilder builder) {
        boolean flag = accountService.addAccount(account);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/account/{id}").buildAndExpand(account.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("account")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
        accountService.updateAccount(account);
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }

    @DeleteMapping("account/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("id") Integer id) {
        accountService.deleteAccount(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
