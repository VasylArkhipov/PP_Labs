package com.Arkhipov.user;

public class Customer {
    private String id;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private String cardNumber;
    private String balance;

    public Customer() {

    }

    //setters

    public void setId(String id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    //getters

    public String getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getAddress() {
        return address;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getBalance() {
        return balance;
    }
}
