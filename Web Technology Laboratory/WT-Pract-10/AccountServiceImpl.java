package com.banking.ejb;

import com.banking.model.Account;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AccountServiceImpl implements AccountService {
    
    @PersistenceContext(unitName = "BankingPU")
    private EntityManager em;

    @Override
    public Account createAccount(String accountNumber, String accountHolder, double initialDeposit) {
        Account account = new Account(accountNumber, accountHolder, initialDeposit);
        em.persist(account);
        return account;
    }

    @Override
    public Account findAccount(String accountNumber) {
        return em.find(Account.class, accountNumber);
    }

    @Override
    public Account deposit(String accountNumber, double amount) throws TransactionException {
        if (amount <= 0) {
            throw new TransactionException("Deposit amount must be positive");
        }
        
        Account account = findAccount(accountNumber);
        if (account == null) {
            throw new TransactionException("Account not found");
        }
        
        account.setBalance(account.getBalance() + amount);
        return em.merge(account);
    }

    @Override
    public Account withdraw(String accountNumber, double amount) throws TransactionException {
        if (amount <= 0) {
            throw new TransactionException("Withdrawal amount must be positive");
        }
        
        Account account = findAccount(accountNumber);
        if (account == null) {
            throw new TransactionException("Account not found");
        }
        
        if (account.getBalance() < amount) {
            throw new TransactionException("Insufficient funds");
        }
        
        account.setBalance(account.getBalance() - amount);
        return em.merge(account);
    }
}