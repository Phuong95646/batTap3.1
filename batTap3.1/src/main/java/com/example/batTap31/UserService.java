package com.example.batTap31;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public void saveOrUpdateUser(UserDemo user) {
        userRepository.save(user);
    }

    public Iterable<UserDemo> getAllUsers() {
        return userRepository.findAll();
    }
}
