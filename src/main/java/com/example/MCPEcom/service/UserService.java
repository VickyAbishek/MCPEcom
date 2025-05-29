package com.example.MCPEcom.service;

import com.example.MCPEcom.dto.UserRequest;
import com.example.MCPEcom.dto.UserResponse;
import com.example.MCPEcom.entity.User;
import com.example.MCPEcom.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    @Tool(description = "Fetch all users from the e-commerce platform")
    public List<UserResponse> getAllUsers() {
        log.info("Fetching all users");
        return userRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Tool(description = "Create single user in the e-commerce platform")
    public List<UserResponse> createUsers(@ToolParam(description = "List of UserRequests which has username and email") List<UserRequest> requests) {
        log.info("Creating {} users", requests.size());
        List<User> users = requests.stream()
                .map(req -> User.builder()
                        .username(req.getUsername())
                        .email(req.getEmail())
                        .build())
                .collect(Collectors.toList());
        return userRepository.saveAll(users).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}