package com.example.service;


import com.example.model.Agency;

import java.util.List;

public interface IAgencyService {

    List<Agency> getAllAgencies();
    Agency getAgencyById(int code);
    boolean addAgency(Agency agency);
    void updateAgency(Agency agency);
    void deleteAgency(int code);

}
