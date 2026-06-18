package org.scoula.board.mapper;

import org.scoula.board.domain.BoardVO;

import java.util.List;

public interface BoardMapper {

    public List<BoardVO> getList();

    // 단일 게시글 조회
    public BoardVO get(Long no);

    // 게시글 등록
    public void create(BoardVO board);

    // 게시글 수정
    public int update(BoardVO board);

    // 게시글 삭제
    public int delete(Long no);

}
