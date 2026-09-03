package com.example.rewards.service;

import com.example.rewards.exception.InvalidTransactionException;
import com.example.rewards.model.RewardSummary;
import com.example.rewards.model.Transaction;
import com.example.rewards.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RewardServiceImpl implements RewardService {

    private final TransactionRepository transactionRepository;

    public RewardServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<RewardSummary> calculateRewards() {

        List<Transaction> transactions = transactionRepository.findAll();

        return transactions
                .stream()
                .collect(Collectors.groupingBy(Transaction::getCustomerId))
                .entrySet()
                .stream()
                .map(entry -> {
                    String customerId = entry.getKey();
                    Map<String, Integer> monthlyPoints = entry.getValue()
                            .stream()
                            .collect(Collectors.groupingBy(
                                    transaction -> transaction
                                            .getTransactionDate()
                                            .getMonth()
                                            .name(),
                                    Collectors.summingInt(
                                            transaction ->
                                                    calculatePoints(transaction.getAmount())
                                    )
                            )
                            );

            int totalPoints = monthlyPoints
                    .values()
                    .stream()
                    .mapToInt(Integer::intValue)
                    .sum();

            return new RewardSummary(customerId, monthlyPoints, totalPoints);
        }).toList();
    }

    private int calculatePoints(BigDecimal amount) {

        if (amount == null) {
            throw new InvalidTransactionException(
                    "Transaction amount cannot be null"
            );
        }

        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidTransactionException(
                    "Transaction amount cannot be negative"
            );
        }

        BigDecimal fifty = BigDecimal.valueOf(50);
        BigDecimal hundred = BigDecimal.valueOf(100);

        if (amount.compareTo(fifty) <= 0) {
            return 0;
        }

        if (amount.compareTo(hundred) <= 0) {
            return amount
                    .subtract(fifty)
                    .intValue();
        }

        return 50
                + amount.subtract(hundred)
                        .multiply(BigDecimal
                        .valueOf(2))
                        .intValue();
    }
}
