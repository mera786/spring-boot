package com.app.NESTED.service;

import com.app.NESTED.entity.Reward;
import com.app.NESTED.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RewardService {

    @Autowired
    private RewardRepository rewardRepository;

    @Transactional(propagation = Propagation.NESTED)
    public void addReward() {

        rewardRepository.save(new Reward("Reward Added"));

        // Force Error
        int x = 10 / 0;
    }
}

