package com.example.chattingwebsocket;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class WebSocketSessionService {
    private final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();
    private final Map<String, Set<String>> userMessages = new HashMap<>();

    // Lưu trữ session khi người dùng kết nối
    public void addSession(String username, WebSocketSession webSocketSession) {
        sessions.put(username, webSocketSession);
        userMessages.put(username, ConcurrentHashMap.newKeySet());
    }

    // Xóa session khi người dùng rời khỏi chat
    public void removeSession(String username) {
        sessions.remove(username);
        userMessages.remove(username);
    }

    // Lưu trữ tin nhắn cho mỗi người dùng
    public void addMessage(String username, String message) {
        Set<String> messages = userMessages.get(username);
        if (messages != null) {
            messages.add(message);
        }
    }

    // Lấy tin nhắn của một người dùng
    public Set<String> getMessages(String username) {
        return userMessages.getOrDefault(username, Collections.emptySet());
    }
}
