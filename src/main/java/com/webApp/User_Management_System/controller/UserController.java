package com.webApp.User_Management_System.controller;

import com.webApp.User_Management_System.model.User;
import com.webApp.User_Management_System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable long id) {
        return userService.findById(id);
    }

    @PostMapping("/add")
    void addUser(@RequestBody User user) {
        userService.addUser(user);
    }
}
