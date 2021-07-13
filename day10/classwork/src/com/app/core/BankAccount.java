package com.app.core;

import java.util.Date;

public class BankAccount implements Comparable<BankAccount> {

    private int accountId;
    private String name;
    private double balance;
    private Date dateOfBirth;
    private AccountType accountType;
    private static int idGenerator;

    static {
        idGenerator = 1000;
    }

    public BankAccount(int accountId) {
        this.accountId = accountId;
    }

    public BankAccount(String name, double balance, Date dateOfBirth, AccountType accountType) {
        this.accountId = idGenerator++;
        this.name = name;
        this.balance = balance;
        this.dateOfBirth = dateOfBirth;
        this.accountType = accountType;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount account = (BankAccount) o;
        return accountId == account.accountId;
    }

    @Override
    public int compareTo(BankAccount bankAccount) {
        if (this == bankAccount) return 0;
        if (accountId > bankAccount.accountId)
            return 1;
        else if (accountId < bankAccount.accountId)
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountId=" + accountId +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", dateOfBirth=" + dateOfBirth +
                ", accountType=" + accountType +
                '}';
    }
}
