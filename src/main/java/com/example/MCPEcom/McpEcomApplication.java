package com.example.MCPEcom;

import com.example.MCPEcom.service.OrderService;
import com.example.MCPEcom.service.ProductService;
import com.example.MCPEcom.service.UserService;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static dev.langchain4j.model.openai.OpenAiChatModelName.GPT_4_O_MINI;

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


	@Bean
	public OpenAiChatModel chatLanguageModel() {
		return OpenAiChatModel.builder()
				.apiKey("key")
				.modelName(GPT_4_O_MINI)
				.strictTools(true)
				.build();
	}

}


interface Assistant {

	String chat(String userMessage);
}