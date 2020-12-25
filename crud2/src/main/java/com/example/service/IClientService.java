package com.example.service;


import com.example.model.Client;

import java.util.List;

public interface IClientService {
    List<Client> getAllClients();
    Client getClientById(int id);
    boolean addClient(Client client);
    void updateClient(Client client);
    void deleteClient(int clientId);

}
