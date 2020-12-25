package com.example.model;

import javax.persistence.*;

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

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "code", nullable = false)
    private Agency agence_code;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private Client client_ID;


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
        return agence_code;
    }

    public void setAgence_code(Agency agence_code) {
        this.agence_code = agence_code;
    }

    public Client getClient_ID() {
        return client_ID;
    }

    public void setClient_ID(Client client_ID) {
        this.client_ID = client_ID;
    }
}
