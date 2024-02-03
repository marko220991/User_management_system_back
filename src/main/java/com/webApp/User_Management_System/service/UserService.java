package com.webApp.User_Management_System.service;

import com.webApp.User_Management_System.exception.EntityNotFoundException;
import com.webApp.User_Management_System.model.User;
import com.webApp.User_Management_System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new EntityNotFoundException("User with id " + id + " not found in database!");
        }
        return userRepository.findById(id);
    }


    public void addUser(User user) {
        userRepository.save(user);
    }
}
