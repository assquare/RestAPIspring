package com.example.controller;

import com.example.model.Account;
import com.example.model.AccountInput;
import com.example.model.Agency;
import com.example.model.Client;
import com.example.repository.AccountRepository;
import com.example.repository.AgencyRepository;
import com.example.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AgencyRepository agencyRepository;

    @GetMapping("accounts/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") int id) {
        Optional<Account> account = accountRepository.findById(id);

        if (account.isPresent()) {
            return new ResponseEntity<>(account.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("accounts")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> list = new ArrayList<Account>();;
        accountRepository.findAll().forEach(list::add);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("accounts")
    public ResponseEntity<Account> addAccount(@RequestBody AccountInput accountInput) {
        Account account = new Account();
        Optional<Client> client = clientRepository.findById(accountInput.getClient_Id());
        account.setClient_ID(client.get());

        Optional<Agency> agency = agencyRepository.findById(accountInput.getAgence_code());
        account.setAgence_code(agency.get());

        try {
            Account _account = accountRepository.save(account);
            return new ResponseEntity<Account>(_account, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("accounts/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable("id") int id, @RequestBody Account account) {
        Optional<Account> accountData = accountRepository.findById(id);
        if (accountData.isPresent()){
            account.setId(id);
            return new ResponseEntity<>(accountRepository.save(account), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("accounts/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("id") int id) {
        try {
            accountRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
