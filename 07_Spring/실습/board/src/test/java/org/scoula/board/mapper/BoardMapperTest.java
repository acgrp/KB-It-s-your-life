package org.scoula.board.mapper;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.domain.BoardVO;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j2
class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    @DisplayName("BoardMapper의 목록 불러오기")
    public void getList() {
        for(BoardVO board : boardMapper.getList()) {
            log.info(board);
        }
    }

    @Test
    void get() {
        BoardVO boardVO = boardMapper.get(1L);

        assertNotNull(boardVO);
        assertEquals(1L,boardVO.getNo());

        log.info("조회된 게시글: {}", boardVO);
    }

    @Test
    void create() {
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("새로 작성하는 글");
        boardVO.setContent("새로 작성하는 내용");
        boardVO.setWriter("user0");

        boardMapper.create(boardVO);

        log.info("생성된 게시글 : {}", boardVO);
        log.info("생성된 게시글 번호: {}", boardVO.getNo());
    }

    @Test
    void update() {
        BoardVO board = new BoardVO();
        board.setNo(5L);                    // 수정할 게시글 번호
        board.setTitle("수정된 제목");
        board.setContent("수정된 내용");
        board.setWriter("user00");

        int count = boardMapper.update(board);   // 수정된 행의 개수 반환

        assertEquals(1, count);             // 1개 행이 수정되었는지 확인
        log.info("UPDATE COUNT: {}", count);


    }

    @Test
    void delete() {

        int count = boardMapper.delete(3L);

        assertEquals(1, count);
        log.info("DELETE COUNT: {}", count);

        BoardVO deleteBoard = boardMapper.get(3L);
        assertNotNull(deleteBoard);

    }
}