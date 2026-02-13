package com.app.REQUIRES_NEW.service;

import com.app.REQUIRES_NEW.entity.Role;
import com.app.REQUIRES_NEW.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void assignRole() {
        roleRepository.save(new Role("USER"));
    }
}

