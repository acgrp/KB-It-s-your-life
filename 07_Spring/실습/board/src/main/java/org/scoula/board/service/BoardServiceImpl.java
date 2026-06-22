package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
<<<<<<< HEAD
import org.scoula.board.domain.BoardVO;
=======
>>>>>>> df685bb1a5adf443dac156cdf1de3d4d441abf52
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;
<<<<<<< HEAD
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;
=======

@Log4j2 // 로그
@Service // 서비스
@RequiredArgsConstructor // final
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper; // Mapper 의존성 주입
>>>>>>> df685bb1a5adf443dac156cdf1de3d4d441abf52

    @Override
    public List<BoardDTO> getList() {

<<<<<<< HEAD
        return boardMapper.getList().stream()    // List<BoardVO> → Stream<BoardVO>
                .map(BoardDTO::of)               // Stream<BoardVO> → Stream<BoardDTO>
                .toList();                       // Stream<BoardDTO> → List<BoardDTO>
=======
        return boardMapper.getList().stream()// List vo - stream vo
                .map(BoardDTO::of) // stream vo - stream dto
                .toList();  // stream dto - list dto
>>>>>>> df685bb1a5adf443dac156cdf1de3d4d441abf52

    }

    @Override
    public BoardDTO get(Long no) {
<<<<<<< HEAD

        BoardVO vo = boardMapper.get(no);               // DB에서 VO 조회
        BoardDTO dto = BoardDTO.of(vo);                 // VO → DTO 변환

        return Optional.ofNullable(dto)                 // null 안전성 처리
                .orElseThrow(NoSuchElementException::new);  // 없으면 예외 발생
=======
        return null;
>>>>>>> df685bb1a5adf443dac156cdf1de3d4d441abf52
    }

    @Override
    public void create(BoardDTO board) {
<<<<<<< HEAD
        log.info("create......" + board);

        BoardVO vo = board.toVo();         // DTO → VO 변환
        boardMapper.create(vo);            // DB에 저장
        board.setNo(vo.getNo());           // 생성된 PK를 DTO에 설정
=======

>>>>>>> df685bb1a5adf443dac156cdf1de3d4d441abf52
    }

    @Override
    public boolean update(BoardDTO board) {
<<<<<<< HEAD
        log.info("update......" + board);

        int affectedRows = boardMapper.update(board.toVo());  // 영향받은 행 수 반환
        return affectedRows == 1;                        // 1개 행이 수정되면 성공
=======
        return false;
>>>>>>> df685bb1a5adf443dac156cdf1de3d4d441abf52
    }

    @Override
    public boolean delete(Long no) {
<<<<<<< HEAD
        log.info("delete...." + no);

        int affectedRows = boardMapper.delete(no);     // 삭제된 행 수 반환
        return affectedRows == 1;                 // 1개 행이 삭제되면 성공
=======
        return false;
>>>>>>> df685bb1a5adf443dac156cdf1de3d4d441abf52
    }
}
