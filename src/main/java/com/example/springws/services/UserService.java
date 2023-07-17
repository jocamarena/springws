package com.example.springws.services;

import com.example.springws.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stubs.com.example.springws.ws.user_service.User;

import java.util.List;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User saveUser(stubs.com.example.springws.ws.user_service.User user) {
        return userRepository.save(user);
    }
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }
    public User getUserByFirstnameAndLastname(String firstname, String lastname) {
        return userRepository.findByFirstnameAndLastname(firstname, lastname);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
