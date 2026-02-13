package com.app.REQUIRES_NEW.service;

import com.app.REQUIRES_NEW.entity.User;
import com.app.REQUIRES_NEW.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AuditService auditService;

    @Transactional(propagation = Propagation.REQUIRED)
    public void registerUser() {
        userRepository.save(new User("Meraz"));

        roleService.assignRole(); // joins same TX

        auditService.saveAuditLog(); // NEW independent TX

        // Simulate failure
        throw new RuntimeException("User Registration Failed");
    }
}

