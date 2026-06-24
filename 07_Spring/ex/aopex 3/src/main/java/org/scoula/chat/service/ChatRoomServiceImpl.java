package org.scoula.chat.service;

import org.scoula.chat.dto.ChatRoomDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ChatRoomServiceImpl implements ChatRoomService {

    // 일단 메모리 저장 (학습용). DB 영속화는 추후 mapper 연동으로 확장 가능
    private final Map<String, ChatRoomDTO> roomMap = new ConcurrentHashMap<>();

    @Override
    public List<ChatRoomDTO> findAllRoom() {
        return new ArrayList<>(roomMap.values());
    }

    @Override
    public ChatRoomDTO findRoomById(String roomId) {
        return roomMap.get(roomId);
    }

    @Override
    public ChatRoomDTO createRoom(String roomName) {
        ChatRoomDTO room = ChatRoomDTO.create(roomName);
        roomMap.put(room.getRoomId(), room);
        return room;
    }

    @Override
    public void removeRoom(String roomId) {
        roomMap.remove(roomId);
    }

    @Override
    public void addUser(String roomId, String sessionId) {
        ChatRoomDTO room = roomMap.get(roomId);
        if (room != null) room.getUserList().add(sessionId);
    }

    @Override
    public void removeUser(String roomId, String sessionId) {
        ChatRoomDTO room = roomMap.get(roomId);
        if (room != null) room.getUserList().remove(sessionId);
    }
}