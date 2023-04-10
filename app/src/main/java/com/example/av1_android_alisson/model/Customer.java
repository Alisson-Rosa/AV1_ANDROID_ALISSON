package com.example.av1_android_alisson.model;

import java.io.Serializable;

public class Customer implements Serializable {
    private String name;
    private String telephone;
    private String email;

    public Customer() {
    }

    public Customer(String name, String telephone, String email) {
        this.name = name;
        this.telephone = telephone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Nome: " + name + "\n" +
        "Telefone: " + telephone + "\n" +
        "Email: " + email;
    }
}
