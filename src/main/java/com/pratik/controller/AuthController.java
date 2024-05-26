package com.pratik.controller;

import com.pratik.model.User;
import com.pratik.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> createUserHandler(@RequestBody User user) {
        // Check if the user already exists
        User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser != null) {
            return new ResponseEntity<>("Email already exists with another account.", HttpStatus.BAD_REQUEST);
        }

        // Create a new user and set the encoded password
        User newUser = new User();
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setEmail(user.getEmail());
        newUser.setFullName(user.getFullName());

        // Save the new user to the repository
        User savedUser = userRepository.save(newUser);

        // Return the response with the created user
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
