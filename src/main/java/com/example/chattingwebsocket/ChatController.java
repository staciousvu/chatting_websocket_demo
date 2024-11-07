package com.example.chattingwebsocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatController {
    @Autowired
    private WebSocketSessionService webSocketSessionService;

    // Danh sách nhóm chat
    private List<String> chatRooms = new ArrayList<>();

    @GetMapping("/chat")
    public String chat() {
        return "chat"; // Trả về tên file chat.html (không cần phần mở rộng .html)
    }

    @GetMapping("/chat/rooms")
    @ResponseBody
    public List<String> getChatRooms() {
        return chatRooms;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        // Lưu trữ tin nhắn vào session của người dùng
        String username = chatMessage.getSender();
        webSocketSessionService.addMessage(username, chatMessage.getContent());
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        String username = chatMessage.getSender();
        headerAccessor.getSessionAttributes().put("username", username);

        // Lưu session của người dùng
//        webSocketSessionService.addSession(username, headerAccessor.getSessionId());

        // Thiết lập loại tin nhắn là JOIN và nội dung thông báo người dùng đã tham gia chat
        chatMessage.setType(ChatMessage.MessageType.JOIN);
        chatMessage.setContent(username + " has joined the chat.");
        return chatMessage;
    }

    @MessageMapping("/chat.leaveUser")
    @SendTo("/topic/public")
    public ChatMessage leaveUser(ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        String username = chatMessage.getSender();
        headerAccessor.getSessionAttributes().remove("username");

        // Thiết lập loại tin nhắn là LEAVE và nội dung thông báo người dùng đã rời khỏi chat
        chatMessage.setType(ChatMessage.MessageType.LEAVE);
        chatMessage.setContent(username + " has left the chat.");
        return chatMessage;
    }
}
