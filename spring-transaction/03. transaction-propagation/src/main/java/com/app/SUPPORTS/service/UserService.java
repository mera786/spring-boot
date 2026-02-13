package com.app.SUPPORTS.service;

import com.app.SUPPORTS.entity.User;
import com.app.SUPPORTS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /*
    ✅ Case 1: Call getUser() normally
                                 No transaction opened (fast performance)

      ✅ Case 2: Call getUser() inside another @Transactional method
                                         It joins that transaction automatically.
     */

    // Read operation
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Write operation
    @Transactional
    public void createUser() {
        userRepository.save(new User("Meraz"));
    }
}

