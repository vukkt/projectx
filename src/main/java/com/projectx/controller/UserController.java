package com.projectx.controller;

import com.projectx.model.User;
import com.projectx.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author vuktopalovic
 * @created 17/10/2023 - 15:35
 * @project projectx
 */
@Slf4j
@RestController
@RequestMapping("/api")
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

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userService.getAllUsers();
        if (!userList.isEmpty()) {
            // Return a 200 OK response with the list of users
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } else {
            // Return a 404 Not Found response if no users are found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        // Attempt to delete the user by ID
        if (userService.getUserById(id) != null) {
            userService.deleteUser(id);
            // Return a 204 No Content response if the user is successfully deleted
            log.info("User with ID {} deleted successfully at {}.", id, LocalDateTime.now());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            // Return a 404 Not Found response if the user with the given ID is not found
            log.warn("Attempt to delete non-existent user with ID {} at {}.", id, LocalDateTime.now());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
