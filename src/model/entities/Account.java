package model.entities;

import model.exceptions.DomainException;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    private Double amount;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit, Double amount) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getNumber() {
        return number;
    }

    public Double getBalance() {
        return balance;
    }

    public String getHolder() {
        return holder;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void updateAccount(Double amount) throws DomainException{
        if (amount > withdrawLimit){
            throw new DomainException("Withdraw error: The amount exceeds withdraw limit");
        }
        if (amount > balance){
            throw  new DomainException("Withdraw error: Not enough balance");
        }
    }

    public Double updateAmount(){
        return balance - amount;
    }
}