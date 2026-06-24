package org.scoula.chat.controller;

import lombok.RequiredArgsConstructor;
import org.scoula.chat.dto.ChatRoomDTO;
import org.scoula.chat.service.ChatRoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chat/rooms")
@RequiredArgsConstructor
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    @GetMapping("")
    public List<ChatRoomDTO> list() {
        return chatRoomService.findAllRoom();
    }

    @PostMapping("")
    public ChatRoomDTO create(@RequestBody Map<String, String> body) {
        return chatRoomService.createRoom(body.get("name"));
    }

    @GetMapping("/{roomId}")
    public ChatRoomDTO detail(@PathVariable String roomId) {
        return chatRoomService.findRoomById(roomId);
    }

    // DELETE 대신 POST + /delete 경로로 변경 (405 에러 회피)
    @PostMapping("/{roomId}/delete")
    public void delete(@PathVariable String roomId) {
        chatRoomService.removeRoom(roomId);
    }
}