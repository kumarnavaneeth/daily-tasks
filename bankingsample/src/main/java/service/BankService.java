package service;

import Repository.AccountRepository;
import exception.BankingException;
import model.Account;

public class BankService {

    private final AccountRepository repository;

    public BankService(AccountRepository repository) {
        this.repository = repository;
    }
    public void deposit(int accountNumber, double amount) {
        Account account = repository.findById(accountNumber);
        if(account==null) {
        	throw new BankingException("Account not found");
        }
        account.deposit(amount);
        repository.save(account);
    }

    public void withdraw(int accountNumber, double amount) {
        Account account = repository.findById(accountNumber);
        account.withdraw(amount);
        repository.save(account);
    }

}
