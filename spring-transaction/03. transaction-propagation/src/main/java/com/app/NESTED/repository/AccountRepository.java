package com.app.NESTED.repository;

import com.app.NESTED.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {}

