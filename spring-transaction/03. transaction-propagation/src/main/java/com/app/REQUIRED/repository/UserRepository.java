package com.app.REQUIRED.repository;


import com.app.REQUIRED.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

