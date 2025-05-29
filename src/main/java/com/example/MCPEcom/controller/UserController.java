package com.example.MCPEcom.controller;

import com.example.MCPEcom.dto.UserRequest;
import com.example.MCPEcom.dto.UserResponse;
import com.example.MCPEcom.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<UserResponse> createUsers(@Valid @RequestBody List<UserRequest> requests) {
        return userService.createUsers(requests);
    }

    // For single user creation
    @PostMapping("/single")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@Valid @RequestBody UserRequest request) {
        return userService.createUsers(List.of(request)).get(0);
    }
}