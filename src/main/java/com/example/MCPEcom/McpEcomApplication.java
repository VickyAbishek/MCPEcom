package com.example.MCPEcom;

import com.example.MCPEcom.service.OrderService;
import com.example.MCPEcom.service.ProductService;
import com.example.MCPEcom.service.UserService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class McpEcomApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpEcomApplication.class, args);
	}

	@Bean
	public ToolCallbackProvider productTools(ProductService productService, UserService userService, OrderService orderService) {
		return MethodToolCallbackProvider.builder()
				.toolObjects(productService, userService, orderService)
				.build();
	}
}
