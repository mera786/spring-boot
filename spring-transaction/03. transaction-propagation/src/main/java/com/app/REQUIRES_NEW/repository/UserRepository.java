package com.app.REQUIRES_NEW.repository;

import com.app.REQUIRES_NEW.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
