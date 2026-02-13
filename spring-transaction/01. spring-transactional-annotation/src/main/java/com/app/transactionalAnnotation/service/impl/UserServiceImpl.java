package com.app.transactionalAnnotation.service.impl;

import com.app.transactionalAnnotation.entity.User;
import com.app.transactionalAnnotation.repository.UserRepository;
import com.app.transactionalAnnotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService { // @Transactional yahin kaam karega

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void createUser() {

        User u1 = new User();
        u1.setName("Meraz");
        userRepository.save(u1);

        // yahan exception aaya to rollback hoga
        if (true) {
            throw new RuntimeException("Something went wrong");
        }

        User u2 = new User();
        u2.setName("Alam");
        userRepository.save(u2);
    }

    // ❌ Ye method transactional nahi hoga
    @Transactional
    private void privateMethod() {
        // Spring proxy isko intercept hi nahi karega
    }
}

