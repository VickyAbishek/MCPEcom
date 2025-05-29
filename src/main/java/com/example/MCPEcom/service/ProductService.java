package com.example.MCPEcom.service;

import com.example.MCPEcom.dto.ProductRequest;
import com.example.MCPEcom.dto.ProductResponse;
import com.example.MCPEcom.entity.Product;
import com.example.MCPEcom.repository.ProductRepository;
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
public class ProductService {
    private final ProductRepository productRepository;

    @Tool(description = "Fetch all products from the e-commerce platform")
    public List<ProductResponse> getAllProducts() {
        log.info("Fetching all products");
        return productRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Tool(description = "Create list of product in the e-commerce platform")
    public List<ProductResponse> createProducts(@ToolParam(description = "List of ProductRequest objects which has title and description") List<ProductRequest> requests) {
        log.info("Creating {} products", requests.size());
        List<Product> products = requests.stream()
                .map(req -> Product.builder()
                        .title(req.getTitle())
                        .description(req.getDescription())
                        .build())
                .collect(Collectors.toList());
        return productRepository.saveAll(products).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private ProductResponse toResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .title(product.getTitle())
                .description(product.getDescription())
                .build();
    }

    @Tool(description = "Fetch a product by its ID")
    public ProductResponse getProductById(@ToolParam(description = "ID of the product") Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        return toResponse(product);
    }

    @Tool(description = "Delete a product by its ID")
    public void deleteProduct(@ToolParam(description = "ID of the product") Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }
}
