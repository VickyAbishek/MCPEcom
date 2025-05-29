package com.example.MCPEcom.repository;

import com.example.MCPEcom.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}