//package com.example.MCPEcom;
//
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/ai")
//public class AiAgentController {
//
//    private final LangChainService langChainService;
//
//    public AiAgentController(LangChainService langChainService) {
//        this.langChainService = langChainService;
//    }
//
//    @PostMapping("/chat")
//    public String chat(@RequestBody String message) {
//        return langChainService.chatWithAgent(message);
//    }
//}
