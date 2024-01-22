package com.projectx.controllers;

import com.projectx.models.User;
import com.projectx.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vuktopalovic
 * @created 17/10/2023 - 15:35
 * @project projectx
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        // Perform user registration and save to the database
        User createdUser = userService.createUser(user);

        if (createdUser != null) {
            // Return a 201 Created response with the created user
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } else {
            // Return a 400 Bad Request response if registration fails
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
