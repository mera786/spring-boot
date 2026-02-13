package com.app.SUPPORTS.repository;

import com.app.SUPPORTS.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

