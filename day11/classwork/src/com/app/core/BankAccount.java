package com.app.core;

import static utils.ValidationUtils.*;

import java.util.Date;

public class BankAccount implements Comparable<BankAccount>{

    private int accountId;
    private String name;
    private double balance;
    private Date creationDate;
    private AccountType type;
    public static int accountIdGenerator;
    static {
        accountIdGenerator = 1000;
    }

    public BankAccount(String name, double balance, Date creationDate, AccountType type) {
        this.accountId = accountIdGenerator++;
        this.name = name;
        this.balance = balance;
        this.creationDate = creationDate;
        this.type = type;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountId=" + accountId +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", creationDate=" + sdf.format(creationDate) +
                ", type=" + type +
                '}';
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        balance = validateBalance(balance - amount);
    }

    public void transferFunds(BankAccount destinationAccount, double amount) throws Exception {
        withdraw(amount);
        destinationAccount.deposit(amount);
    }

    @Override
    public int compareTo(BankAccount account) {
        return ((Integer) this.accountId).compareTo((Integer) account.accountId);
    }

    public int getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public AccountType getType() {
        return type;
    }

    public void applyInterest(double rate) {
        balance += (balance * rate) / 100;
    }
}
