package com.banking.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Account.findByAccountNumber", 
            query="SELECT a FROM Account a WHERE a.accountNumber = :accountNumber")
public class Account implements Serializable {
    
    @Id
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructors, getters and setters
    public Account() {}
    
    public Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    
    public String getAccountHolder() { return accountHolder; }
    public void setAccountHolder(String accountHolder) { this.accountHolder = accountHolder; }
    
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}