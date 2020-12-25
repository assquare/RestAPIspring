package com.example.service;


import com.example.model.Agency;
import com.example.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AgencyService implements IAgencyService {

    @Autowired
    private AgencyRepository agencyRepository;

    @Override
    public List<Agency> getAllAgencies() {
        List<Agency> list = new ArrayList<>();
        agencyRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Agency getAgencyById(int code) {
        Agency obj = agencyRepository.findById(code).get();
        return obj;
    }

    @Override
    public boolean addAgency(Agency agency) {
        agencyRepository.save(agency);
        return true;
    }

    @Override
    public void updateAgency(Agency agency) {
        agencyRepository.save(agency);
    }

    @Override
    public void deleteAgency(int code) {
        agencyRepository.delete(getAgencyById(code));
    }
}
