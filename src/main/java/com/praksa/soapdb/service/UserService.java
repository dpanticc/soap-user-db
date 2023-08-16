package com.praksa.soapdb.service;


import com.praksa.soapdb.model.User;
import org.springframework.stereotype.Service;


@Service
public interface UserService {

    void AddUser(User user);
    User getUser(String email);
}
