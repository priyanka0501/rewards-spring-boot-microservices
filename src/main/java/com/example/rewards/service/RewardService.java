package com.example.rewards.service;

import com.example.rewards.model.RewardSummary;

import java.util.List;

public interface RewardService {
    List<RewardSummary> calculateRewards();
}

