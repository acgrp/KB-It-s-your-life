package org.scoula.chat.dto;

import lombok.Data;

@Data
public class ChatMessageDTO {

    public enum MessageType { ENTER, TALK, LEAVE }

    private MessageType type;
    private String roomId;
    private String sender;
    private String message;
}