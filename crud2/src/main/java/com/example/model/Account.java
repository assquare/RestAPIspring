package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "compte")
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "solde")
    private double solde;

    @Column(name = "decouvert")
    private double decouvert;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "agence_code", nullable = false)
    private Agency agence;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_Id",referencedColumnName = "id", nullable = false)
    private Client client;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }

    public Agency getAgence_code() {
        return agence;
    }

    public void setAgence_code(Agency agence_code) {
        this.agence = agence_code;
    }

    public Client getClient_ID() {
        return client;
    }

    public void setClient_ID(Client client_ID) {
        this.client= client_ID;
    }
}
