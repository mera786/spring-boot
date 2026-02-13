package com.app.REQUIRED.service;


import com.app.REQUIRED.entity.Role;
import com.app.REQUIRED.repository.RoleRepository;
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
//        int ans = 10/0;
//        System.out.println(ans);
        roleRepository.save(new Role("ADMIN"));

        // Uncomment to test rollback
        // throw new RuntimeException("Role Failed");
    }
}

