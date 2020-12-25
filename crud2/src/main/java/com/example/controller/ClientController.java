package com.example.controller;


import com.example.model.Client;
import com.example.service.ClientService;
import com.example.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("client/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") int id) {
        Client client = clientService.getClientById(id);
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }

    @GetMapping("clients")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> list = clientService.getAllClients();
        return new ResponseEntity<List<Client>>(list, HttpStatus.OK);
    }

    @PostMapping("client")
    public ResponseEntity<Void> addClient(@RequestBody Client client, UriComponentsBuilder builder) {
        boolean flag = clientService.addClient(client);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/client/{id}").buildAndExpand(client.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("client")
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        clientService.updateClient(client);
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }

    @DeleteMapping("client/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable("id") int id) {
        clientService.deleteClient(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
