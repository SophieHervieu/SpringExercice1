package com.adrar.exercice1.controller;

import com.adrar.exercice1.model.User;
import com.adrar.exercice1.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.findUserById(id);
    }

    @PostMapping("/user")
        public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
            return ResponseEntity.ok(userService.saveUser(user));
    }
}
