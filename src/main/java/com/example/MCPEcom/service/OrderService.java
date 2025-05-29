package com.example.MCPEcom.service;

import com.example.MCPEcom.dto.OrderResponse;
import com.example.MCPEcom.dto.UserResponse;
import com.example.MCPEcom.dto.ProductResponse;
import com.example.MCPEcom.entity.Order;
import com.example.MCPEcom.repository.OrderRepository;
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
public class OrderService {
    private final OrderRepository orderRepository;

    @Tool(description = "Fetch all orders from the e-commerce platform")
    public List<OrderResponse> getAllOrders() {
        log.info("Fetching all orders");
        return orderRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private OrderResponse toResponse(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .user(UserResponse.builder()
                        .id(order.getUser().getId())
                        .username(order.getUser().getUsername())
                        .email(order.getUser().getEmail())
                        .build())
                .product(ProductResponse.builder()
                        .id(order.getProduct().getId())
                        .title(order.getProduct().getTitle())
                        .description(order.getProduct().getDescription())
                        .build())
                .build();
    }
}