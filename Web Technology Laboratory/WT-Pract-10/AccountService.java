package com.banking.ejb;

import com.banking.model.Account;
import javax.ejb.Remote;

@Remote
public interface AccountService {
    Account createAccount(String accountNumber, String accountHolder, double initialDeposit);
    Account findAccount(String accountNumber);
    Account deposit(String accountNumber, double amount) throws TransactionException;
    Account withdraw(String accountNumber, double amount) throws TransactionException;
}