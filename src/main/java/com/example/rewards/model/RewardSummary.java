package com.example.rewards.model;

import java.util.Map;

public class RewardSummary {

    private String customerId;
    private Map<String, Integer> monthlyPoints;
    private int totalPoints;

    public RewardSummary(String customerId,
                         Map<String, Integer> monthlyPoints,
                         int totalPoints) {
        this.customerId = customerId;
        this.monthlyPoints = monthlyPoints;
        this.totalPoints = totalPoints;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Map<String, Integer> getMonthlyPoints() {
        return monthlyPoints;
    }

    public int getTotalPoints() {
        return totalPoints;
    }
}
