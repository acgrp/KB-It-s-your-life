package org.scoula.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardViewController {

    /** 게시글 목록 페이지 */
    @GetMapping("/list")
    public String list() {
        return "board/list";
    }

    /** 게시글 상세 페이지 (id는 JS에서 URL 파라미터로 처리) */
    @GetMapping("/view")
    public String view() {
        return "board/view";
    }
}
