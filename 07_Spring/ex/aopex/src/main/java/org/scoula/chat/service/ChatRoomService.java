package org.scoula.chat.service;

import org.scoula.chat.dto.ChatRoomDTO;
import java.util.List;

public interface ChatRoomService {
    List<ChatRoomDTO> findAllRoom();
    ChatRoomDTO findRoomById(String roomId);
    ChatRoomDTO createRoom(String roomName);
    void removeRoom(String roomId);
    void addUser(String roomId, String sessionId);
    void removeUser(String roomId, String sessionId);
}