package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/signup")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<String> registerUser(@Valid @RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully!");
    }
}
