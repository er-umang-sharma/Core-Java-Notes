package com.app.core;

import java.util.Date;
import java.util.Objects;

public class BankAccount {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount account = (BankAccount) o;
        return accountId == account.accountId;
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
