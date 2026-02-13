package com.app.random;

import com.app.entity.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(transactionManager = "transactionManager")
    public void bookAdd(){
        User user = new User();
        user.setId(1);
        user.setName("sahil");
        userRepository.save(user);
    }
}
