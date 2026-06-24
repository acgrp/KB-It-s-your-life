package org.scoula.chat.controller;

import lombok.RequiredArgsConstructor;
import org.scoula.chat.dto.ChatMessageDTO;
import org.scoula.chat.service.ChatRoomService;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatMessageController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatRoomService chatRoomService;

    // 클라이언트는 /app/chat/{roomId} 로 발행(publish)
    @MessageMapping("/chat/{roomId}")
    public void chat(@DestinationVariable String roomId,
                     ChatMessageDTO message,
                     @Header("simpSessionId") String sessionId) {

        switch (message.getType()) {
            case ENTER:
                chatRoomService.addUser(roomId, sessionId);
                message.setMessage(message.getSender() + "님이 입장했습니다.");
                break;
            case LEAVE:
                chatRoomService.removeUser(roomId, sessionId);
                message.setMessage(message.getSender() + "님이 퇴장했습니다.");
                break;
            default:
                break;
        }
        // 방 번호별 동적 토픽으로 전송 (PDF의 @SendTo는 고정주소만 가능해서 못씀)
        messagingTemplate.convertAndSend("/topic/chat/" + roomId, message);
    }
}