package com.example.rewards.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {

    private Long id;
    private String customerId;
    private BigDecimal amount;
    private LocalDate transactionDate;

    public Transaction() {
    }

    public Transaction(Long id, String customerId,
                       BigDecimal amount,
                       LocalDate transactionDate) {
        this.id = id;
        this.customerId = customerId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public Long getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }
}
