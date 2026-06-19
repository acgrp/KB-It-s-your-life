package org.scoula.board.service;

import org.scoula.board.dto.BoardDTO;

import java.util.List;

public interface BoardService {

    public List<BoardDTO> getList(); // 목록 조회

    public BoardDTO get(Long no); // 특정 조회

    public void create(BoardDTO board); // 등록

    public boolean update(BoardDTO board); // 수정

    public boolean delete(Long no); // 삭제

}
