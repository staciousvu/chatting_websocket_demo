package com.example.chattingwebsocket;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketEventListener {

    private final WebSocketSessionService webSocketSessionService;

    public WebSocketEventListener(WebSocketSessionService webSocketSessionService) {
        this.webSocketSessionService = webSocketSessionService;
    }

//    @EventListener
//    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
//        // Lưu username từ session attributes
//        String username = (String) event.getSessionId(); // Cần điều chỉnh cách lấy username
//        if (username != null) {
//            webSocketSessionService.removeSession(username);
//            System.out.println("User disconnected: " + username);
//        }
//    }
}
