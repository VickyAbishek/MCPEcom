package com.example.MCPEcom;

import com.example.MCPEcom.service.ProductServiceTool;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LangChainDemoRunner implements CommandLineRunner {

    private final OpenAiChatModel chatModel;
    private final ProductServiceTool productServiceTool; // Your tool

    // Inject the ChatLanguageModel bean and your ProductServiceTool bean
    public LangChainDemoRunner(OpenAiChatModel chatModel, ProductServiceTool productServiceTool) {
        this.chatModel = chatModel;
        this.productServiceTool = productServiceTool;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running LangChain4j Demo with ProductServiceTool...");

        // Build the Assistant using AiServices, with the injected model and tool
        Assistant assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(chatModel) // Use the injected OpenAiChatModel
                .tools(productServiceTool) // Use your ProductServiceTool here
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .build();

        // Example question relevant to your ProductServiceTool
        // (assuming ProductServiceTool has a method like "getAllProducts" annotated with @Tool)
        String question = "Can you list all available products?";
        // Or, if your @Tool description is "Retrieves all products":
        // String question = "Retrieves all products";


        String answer = assistant.chat(question);
        System.out.println("Assistant's answer: " + answer);

        // You can add more interactions here to test other tool methods
        // For example, if you have a tool method "getProductById(Long id)":
        // String questionById = "Get product with ID 1";
        // String answerById = assistant.chat(questionById);
        // System.out.println("Assistant's answer for product ID 1: " + answerById);
    }
}