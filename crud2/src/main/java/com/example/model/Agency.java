package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "agence")
public class Agency {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "code")
    private int code;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_Number")
    private String phone_Number;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_Number() {
        return phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        this.phone_Number = phone_Number;
    }

}
