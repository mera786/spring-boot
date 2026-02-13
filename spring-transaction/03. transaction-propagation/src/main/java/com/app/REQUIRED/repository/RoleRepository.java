package com.app.REQUIRED.repository;


import com.app.REQUIRED.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}

