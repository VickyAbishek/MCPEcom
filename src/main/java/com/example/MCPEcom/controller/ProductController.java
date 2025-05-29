package com.example.MCPEcom.controller;

import com.example.MCPEcom.dto.ProductRequest;
import com.example.MCPEcom.dto.ProductResponse;
import com.example.MCPEcom.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<ProductResponse> createProducts(@Valid @RequestBody List<ProductRequest> requests) {
        return productService.createProducts(requests);
    }

    // For single product creation
    @PostMapping("/single")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@Valid @RequestBody ProductRequest request) {
        return productService.createProducts(List.of(request)).get(0);
    }


}