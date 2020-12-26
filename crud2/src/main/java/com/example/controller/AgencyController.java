package com.example.controller;

import com.example.model.Agency;
import com.example.model.Client;
import com.example.repository.AgencyRepository;

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
@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
@RequestMapping(value="/api")
public class AgencyController {


    @Autowired
    private AgencyRepository agencyRepository;

    @GetMapping("agencies/{code}")
    public ResponseEntity<Agency> getAgencyById(@PathVariable("code") int code) {
        Optional<Agency> agency = agencyRepository.findById(code);

        if (agency.isPresent()) {
            return new ResponseEntity<>(agency.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("agencies")
    public ResponseEntity<List<Agency>> getAllAgencies() {
        List<Agency> list = new ArrayList<Agency>();;
        agencyRepository.findAll().forEach(list::add);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("agencies")
    public ResponseEntity<Agency> addAgency(@RequestBody Agency agency) {
        try {
            Agency _agency = agencyRepository.save(agency);
            return new ResponseEntity<Agency>(_agency, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("agencies/{code}")
    public ResponseEntity<Agency> updateAgency(@PathVariable("code") int code, @RequestBody Agency agency) {
        Optional<Agency> agencyData = agencyRepository.findById(code);
        if (agencyData.isPresent()){
            agency.setCode(code);
            return new ResponseEntity<>(agencyRepository.save(agency), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("agencies/{code}")
    public ResponseEntity<Void> deleteAgency(@PathVariable("code") int code) {
        try {
            agencyRepository.deleteById(code);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
