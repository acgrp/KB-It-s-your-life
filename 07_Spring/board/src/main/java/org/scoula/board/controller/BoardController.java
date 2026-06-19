package org.scoula.board.controller;

import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.log4j.Log4j2;
import lombok.RequiredArgsConstructor;

@Log4j2                           // 로깅을 위한 Lombok 어노테이션
@Controller                       //요청/응답 제어하는 클래스임을 명시 + Bean 등록ㅌ
// Spring MVC Controller 지정
@RequestMapping("/board")         // 기본 URL 패턴 설정
@RequiredArgsConstructor         // final 필드 생성자 자동 생성
public class BoardController {

    // 의존성 주입: BoardService를 통해 비즈니스 로직 처리
    final private BoardService service;

    // 목록 조회
    @GetMapping("/list")
    public void list(Model model) {
        // Model : 데이터 전달용 객체
        log.info("list");                           // 로그 출력
        model.addAttribute("list", service.getList()); // Model에 목록 데이터 추가
    }
// 반환 타입이 void인 경우 요청 URL과 동일한 뷰 이름 자동 매핑: "board/list"

    // 등록 폼 표시
    @GetMapping("/create")
    public void create() {
        log.info("create");
        // 뷰 이름: "board/create"
    }

    // 등록 처리
    @PostMapping("/create")
    public String create(BoardDTO board) {
        log.info("create: " + board);           // 입력 데이터 로그
        service.create(board);                  // 게시글 생성
        return "redirect:/board/list";          // 목록으로 리다이렉트
    }
}