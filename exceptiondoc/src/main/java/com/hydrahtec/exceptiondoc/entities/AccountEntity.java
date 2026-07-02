package com.hydrahtec.exceptiondoc.entities;

public class AccountEntity {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public AccountEntity() {}

    public AccountEntity (Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public String validadeWithdraw(double amount) {
        if (amount > getWithdrawLimit()) {
            return "Erro de saque: A quantia excede o limite de saque.";
        } else if (amount > getBalance()) {
            return "Erro de saque: Saldo insuficiente";
        }
        return null;
    }
}
