package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    final private BoardService service;

    @GetMapping("/list")
    public void list(Model model) {

        model.addAttribute("list", service.getList()); // Model에 목록 데이터 추가
    }

    // 등록 폼 표시
    @GetMapping("/create")
    public void create() {

    }

    // 등록 처리
    @PostMapping("/create")
    public String create(BoardDTO board) {

        service.create(board);

        return "redirect:/board/list";
    }

    @GetMapping({ "/get", "/update" })           // 두 개의 URL을 같은 메서드에서 처리
    public void get(@RequestParam("no") Long no, Model model) {

        model.addAttribute("board", service.get(no)); // 특정 게시글 조회
    }

    @PostMapping("/update")
    public String update(BoardDTO board) {

        log.info("update:" + board);

        boolean result = service.update(board);                   // 게시글 수정

        log.info("update result: " + result);

        return "redirect:/board/list";           // 목록으로 리다이렉트
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("no") Long no) {
        log.info("delete..." + no);
        boolean result = service.delete(no);                      // 게시글 삭제
        log.info("delete result: " + result);
        return "redirect:/board/list";           // 목록으로 리다이렉트
    }



}
