package com.app.NESTED.service;

import com.app.NESTED.entity.Account;
import com.app.NESTED.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RewardService rewardService;

    @Transactional
    public void transferMoney() {

        Account acc = new Account();
        acc.setName("Meraz");
        acc.setBalance(5000);
        accountRepository.save(acc);

        // Nested Transaction Call
        rewardService.addReward();

        System.out.println("Money Transfer Completed");
    }
}

