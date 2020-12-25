package com.example.service;

import com.example.model.Client;
import com.example.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ClientService implements IClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        List<Client> list = new ArrayList<>();
        clientRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Client getClientById(int id) {
        Client obj = clientRepository.findById((long) id).get();
        return obj;
    }

    @Override
    public synchronized boolean addClient(Client client) {
            clientRepository.save(client);
            return true;
    }

    @Override
    public void updateClient(Client client) {
            clientRepository.save(client);
    }

    @Override
    public void deleteClient(int clientId) {
            clientRepository.delete(getClientById(clientId));
    }
}
