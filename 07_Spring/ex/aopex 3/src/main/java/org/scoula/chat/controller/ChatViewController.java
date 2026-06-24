package org.scoula.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatViewController {

    @GetMapping("/list")
    public String list() {
        return "chat/list"; // /WEB-INF/views/chat/list.jsp
    }

    @GetMapping("/room/{roomId}")
    public String room(@PathVariable String roomId, Model model) {
        model.addAttribute("roomId", roomId);
        return "chat/room"; // /WEB-INF/views/chat/room.jsp
    }
}