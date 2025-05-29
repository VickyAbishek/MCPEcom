package com.example.MCPEcom.repository;

import com.example.MCPEcom.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}