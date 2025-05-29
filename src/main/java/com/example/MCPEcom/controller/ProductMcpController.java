//package com.example.MCPEcom.controller;
//
//
//import com.example.MCPEcom.dto.ProductRequest;
//import com.example.MCPEcom.dto.ProductResponse;
//import com.example.MCPEcom.service.ProductService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.ai.tool.annotation.Tool;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@RequiredArgsConstructor
//public class ProductMcpController {
//
//    private final ProductService productService;
//
//    @Tool(description = "Fetch all products from the e-commerce platform")
//    public List<ProductResponse> getAllProducts() {
//        return productService.getAllProducts();
//    }
//
//    @Tool(description = "Create multiple products in the e-commerce platform")
//    public List<ProductResponse> createProducts(@RequestBody List<ProductRequest> requests) {
//        return productService.createProducts(requests);
//    }
//
//    @Tool(description = "Create a single product in the e-commerce platform")
//    public ProductResponse createProduct(@RequestBody ProductRequest request) {
//        return productService.createProducts(List.of(request)).get(0);
//    }
//
//    @Tool(description = "Fetch a product by its ID")
//    public ProductResponse getProductById(@RequestParam Long id) {
//        // Implement this in ProductService and call here
//        return productService.getProductById(id);
//    }
//
//    @Tool(description = "Delete a product by its ID")
//    public void deleteProduct(@RequestParam Long id) {
//        // Implement this in ProductService and call here
//        productService.deleteProduct(id);
//    }
//}