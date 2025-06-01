package com.example.MCPEcom.service;

import com.example.MCPEcom.dto.ProductRequest;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceTool {

    private final ProductService productService;

    public ProductServiceTool(ProductService productService) {
        this.productService = productService;
    }

    @Tool("Retrieves all products")
    public String getAllProducts() {
        return productService.getAllProducts().toString();
    }

    @Tool("Creates a List of products")
    public String createProducts(List<ProductRequest> requests) {
        return productService.createProducts(requests).toString();
    }

    @Tool("Retrieves a product by its ID")
    public String getProductById(Long id) {
        return productService.getProductById(id).toString();
    }

    @Tool("Updates a product by its ID")
    public void deleteProductById(Long id) {
        productService.getProductById(id);
    }
}
