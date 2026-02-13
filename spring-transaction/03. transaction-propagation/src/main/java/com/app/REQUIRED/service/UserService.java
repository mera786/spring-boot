package com.app.REQUIRED.service;


import com.app.REQUIRED.entity.User;
import com.app.REQUIRED.repository.UserRepository;
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

    @Transactional(propagation = Propagation.REQUIRED)
    public void registerUser() {
        userRepository.save(new User("Meraz"));

        roleService.assignRole(); // joins same transaction

        // Uncomment to test rollback
        // throw new RuntimeException("User Failed");
    }
}

