package com.example.model;

import javax.persistence.*;

public class AccountInput {


    private double solde;

    private double decouvert;

    private int agence_code;
    private int client_Id;

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

    public int getAgence_code() {
        return agence_code;
    }

    public void setAgence_code(int agence_code) {
        this.agence_code = agence_code;
    }

    public int getClient_Id() {
        return client_Id;
    }

    public void setClient_Id(int client_Id) {
        this.client_Id = client_Id;
    }
}
