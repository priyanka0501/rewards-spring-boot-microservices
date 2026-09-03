package com.example.rewards.repository;

import com.example.rewards.model.Transaction;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public class TransactionRepository {

    private final List<Transaction> transactions = List.of(

            new Transaction(
                    1L,
                    "C001",
                    new BigDecimal("120.00"),
                    LocalDate.of(2026, 1, 10)
            ),

            new Transaction(
                    2L,
                    "C001",
                    new BigDecimal("75.00"),
                    LocalDate.of(2026, 1, 20)
            ),

            new Transaction(
                    3L,
                    "C001",
                    new BigDecimal("150.00"),
                    LocalDate.of(2026, 2, 5)
            ),

            new Transaction(
                    4L,
                    "C001",
                    new BigDecimal("40.00"),
                    LocalDate.of(2026, 2, 15)
            ),

            new Transaction(
                    5L,
                    "C002",
                    new BigDecimal("200.00"),
                    LocalDate.of(2026, 1, 12)
            ),

            new Transaction(
                    6L,
                    "C002",
                    new BigDecimal("90.00"),
                    LocalDate.of(2026, 2, 10)
            ),

            new Transaction(
                    7L,
                    "C002",
                    new BigDecimal("110.00"),
                    LocalDate.of(2026, 3, 8)
            )
    );

    public List<Transaction> findAll() {
        return transactions;
    }
}
