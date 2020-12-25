package com.example.controller;

import com.example.model.Agency;
import com.example.service.AgencyService;
import com.example.service.IAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
@RequestMapping(value="/api")
public class AgencyController {

    @Autowired
    private AgencyService agencyService;

    @GetMapping("agency/{code}")
    public ResponseEntity<Agency> getAgencyById(@PathVariable("code") int code) {
        Agency agency = agencyService.getAgencyById(code);
        return new ResponseEntity<Agency>(agency, HttpStatus.OK);
    }

    @GetMapping("agencies")
    public ResponseEntity<List<Agency>> getAllAgencies() {
        List<Agency> list = agencyService.getAllAgencies();
        return new ResponseEntity<List<Agency>>(list, HttpStatus.OK);
    }

    @PostMapping("agency")
    public ResponseEntity<Void> addAgency(@RequestBody Agency agency, UriComponentsBuilder builder) {
        boolean flag = agencyService.addAgency(agency);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/agency/{code}").buildAndExpand(agency.getCode()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("agency")
    public ResponseEntity<Agency> updateAgency(@RequestBody Agency agency) {
        agencyService.updateAgency(agency);
        return new ResponseEntity<Agency>(agency, HttpStatus.OK);
    }

    @DeleteMapping("agency/{code}")
    public ResponseEntity<Void> deleteAgency(@PathVariable("code") int code) {
        agencyService.deleteAgency(code);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
