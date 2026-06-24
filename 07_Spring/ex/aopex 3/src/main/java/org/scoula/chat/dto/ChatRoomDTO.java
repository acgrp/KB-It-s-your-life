package org.scoula.chat.dto;

import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Data
public class ChatRoomDTO {

    private String roomId;
    private String roomName;
    private Set<String> userList = new LinkedHashSet<>();

    public static ChatRoomDTO create(String roomName) {
        ChatRoomDTO room = new ChatRoomDTO();
        room.roomId = UUID.randomUUID().toString();
        room.roomName = roomName;
        return room;
    }
}