package com.praksa.soapdb.service;

import com.praksa.soapdb.model.User;
import com.praksa.soapdb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void AddUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }
}
