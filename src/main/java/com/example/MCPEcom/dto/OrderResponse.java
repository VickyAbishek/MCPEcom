package com.example.MCPEcom.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {
    private Long id;
    private UserResponse user;
    private ProductResponse product;
}