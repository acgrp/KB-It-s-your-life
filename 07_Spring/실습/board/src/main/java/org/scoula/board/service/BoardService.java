package org.scoula.board.service;

import org.scoula.board.dto.BoardDTO;

import java.util.List;

public interface BoardService {

<<<<<<< HEAD
    public List<BoardDTO> getList();

    public BoardDTO get(Long no);

    public void create(BoardDTO board);

    public boolean update(BoardDTO board);

    public boolean delete(Long no);
=======
    public List<BoardDTO> getList(); // 목록 조회

    public BoardDTO get(Long no); // 특정 조회

    public void create(BoardDTO board); // 등록

    public boolean update(BoardDTO board); // 수정

    public boolean delete(Long no); // 삭제
>>>>>>> df685bb1a5adf443dac156cdf1de3d4d441abf52

}
