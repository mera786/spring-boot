package com.app.transactionalAnnotation.repository;

import com.app.transactionalAnnotation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

