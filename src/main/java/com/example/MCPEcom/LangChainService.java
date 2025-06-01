//package com.example.MCPEcom;
//
//import com.example.MCPEcom.service.ProductServiceTool;
//import dev.langchain4j.model.chat.ChatLanguageModel;
//import dev.langchain4j.service.AiServices;
//import org.springframework.stereotype.Service;
//
///**
// * Defines the capabilities of our AI assistant.
// * LangChain4j will implement this interface.
// */
//interface ProductAssistant {
//
//    /**
//     * Interacts with the AI assistant.
//     * @param userMessage The message from the user.
//     * @return The AI's response.
//     */
//    String chat(String userMessage);
//}
//
//@Service
//public class LangChainService {
//
//    private final ProductAssistant assistant;
//
//    /**
//     * Constructs the LangChainService.
//     * @param chatLanguageModel The chat model to be used by the assistant (e.g., OpenAiChatModel).
//     *                          This is typically auto-configured by LangChain4j Spring Boot starter.
//     * @param productServiceTool The tool(s) that the assistant can use.
//     */
//    public LangChainService(ChatLanguageModel chatLanguageModel, ProductServiceTool productServiceTool) {
//        this.assistant = AiServices.builder(ProductAssistant.class)
//                .chatLanguageModel(chatLanguageModel)
//                .tools(productServiceTool)
//                .build();
//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
//    }
//
//    /**
//     * Allows interaction with the configured AI assistant.
//     * @param userMessage The message from the user.
//     * @return The AI's response, potentially after using tools.
//     */
//    public String chatWithAgent(String userMessage) {
//        return assistant.chat(userMessage);
//    }
//}