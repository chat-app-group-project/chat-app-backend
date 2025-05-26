package lk.kelaniya.chatapp.controller;

import lk.kelaniya.chatapp.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatRestController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @PostMapping("/send")
    public String sendMessage(@RequestBody ChatMessage message) {
        messagingTemplate.convertAndSend("/topic/public", message);
        return "Message sent to /topic/public";
    }
}
