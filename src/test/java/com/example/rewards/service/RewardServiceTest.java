package com.example.rewards.service;

import com.example.rewards.model.RewardSummary;
import com.example.rewards.model.Transaction;
import com.example.rewards.repository.TransactionRepository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RewardServiceTest {

    private final TransactionRepository transactionRepository =
            mock(TransactionRepository.class);

    private final RewardServiceImpl rewardService =
            new RewardServiceImpl(transactionRepository);


    @Test
    void shouldReturnZeroPointsWhenAmountIsBelow50() {

        Transaction transaction = new Transaction(
                1L,
                "C001",
                new BigDecimal("40.00"),
                LocalDate.of(2026, 1, 10)
        );

        when(transactionRepository.findAll())
                .thenReturn(List.of(transaction));

        List<RewardSummary> result = rewardService.calculateRewards();

        assertEquals(0, result.get(0).getTotalPoints());
    }


    @Test
    void shouldReturnZeroPointsWhenAmountIs50() {

        Transaction transaction = new Transaction(
                1L,
                "C001",
                new BigDecimal("50.00"),
                LocalDate.of(2026, 1, 10)
        );

        when(transactionRepository.findAll())
                .thenReturn(List.of(transaction));

        List<RewardSummary> result = rewardService.calculateRewards();

        assertEquals(0, result.get(0).getTotalPoints());
    }


    @Test
    void shouldCalculatePointsBetween50And100() {

        Transaction transaction = new Transaction(
                1L,
                "C001",
                new BigDecimal("80.00"),
                LocalDate.of(2026, 1, 10)
        );

        when(transactionRepository.findAll())
                .thenReturn(List.of(transaction));

        List<RewardSummary> result = rewardService.calculateRewards();

        assertEquals(30, result.get(0).getTotalPoints());
    }


    @Test
    void shouldCalculatePointsAbove100() {

        Transaction transaction = new Transaction(
                1L,
                "C001",
                new BigDecimal("120.00"),
                LocalDate.of(2026, 1, 10)
        );

        when(transactionRepository.findAll())
                .thenReturn(List.of(transaction));

        List<RewardSummary> result = rewardService.calculateRewards();

        assertEquals(90, result.get(0).getTotalPoints());
    }
}