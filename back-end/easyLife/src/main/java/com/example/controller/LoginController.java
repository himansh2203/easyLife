package com.example.controller;

import com.example.dto.LoginRequest;
import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
        // Find user by email
        User user = userRepository.findByEmail(loginRequest.getEmail());

        if (user == null) {
            return ResponseEntity.status(404).body("User not found");
        }

        // Check if the password matches
        if (!user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        return ResponseEntity.ok("Login successful");
    }
}