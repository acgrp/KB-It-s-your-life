package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2 // 로그
@Service // 서비스
@RequiredArgsConstructor // final
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper; // Mapper 의존성 주입

    @Override
    public List<BoardDTO> getList() {

        return boardMapper.getList().stream()// List vo - stream vo
                .map(BoardDTO::of) // stream vo - stream dto
                .toList();  // stream dto - list dto

    }

    @Override
    public BoardDTO get(Long no) {
        return null;
    }

    @Override
    public void create(BoardDTO board) {

    }

    @Override
    public boolean update(BoardDTO board) {
        return false;
    }

    @Override
    public boolean delete(Long no) {
        return false;
    }
}
