package com.thoma.finmanapi.controller;

import com.thoma.finmanapi.dto.request.UserRequest;
import com.thoma.finmanapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getUser(@RequestParam String username) {
        return new ResponseEntity<>(userService.findUserByUsername(username),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.findUser(id),
                HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.createUser(userRequest),
                HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.updateUser(userRequest),
                HttpStatus.OK);
    }

}
