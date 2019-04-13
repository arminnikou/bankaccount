package com.rayanen.bankAccount.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "ARN_BANKACCOUNT")
public  class BankAccount {
    @Id
    @GeneratedValue
    private Integer id;

    private String accountNumber;

    private AccountType accountTypes;

    //mojody
    public BigDecimal inventory;

    @Version
    private Integer version;

    //vaze hesab
    private ActiveType activeType;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ARN_BANKACCOUNT_TRANSACTIONS")
    private List<Transaction> transactions;



    public ActiveType getActiveType() {
        return activeType;
    }

    public void setActiveType(ActiveType activeType) {
        this.activeType = activeType;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }


    public AccountType getAccountTypes() {
        return accountTypes;
    }

    public void setAccountTypes(AccountType accountTypes) {
        this.accountTypes = accountTypes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public AccountType getAccountType() {
        return accountTypes;
    }

    public void setAccountType(AccountType accountType) {
        this.accountTypes = accountType;
    }

    public BigDecimal getInventory() {
        return inventory;
    }

    public void setInventory(BigDecimal inventory) {
        this.inventory = inventory;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

}
