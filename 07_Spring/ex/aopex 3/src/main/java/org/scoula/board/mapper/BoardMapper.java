package org.scoula.board.mapper;

import org.scoula.board.dto.AttachmentDTO;
import org.scoula.board.dto.BoardDTO;

import java.util.List;

public interface BoardMapper {
    // 게시글 목록 조회
    List<BoardDTO> selectAll();

    // 게시글 단건 조회
    BoardDTO selectById(Long id);

    // 게시글 등록
    void insert(BoardDTO board);

    // 게시글 수정
    void update(BoardDTO board);

    // 게시글 삭제
    void delete(Long id);

    // ──── 첨부파일 BLOB 관련 ────

    // 첨부파일 메타 + BLOB 저장
    void insertAttachment(AttachmentDTO attachment);

    // 게시글의 첨부파일 목록 조회 (파일 데이터 제외)
    List<AttachmentDTO> selectAttachmentsByBoardId(Long boardId);

    // 단건 첨부파일 조회 (BLOB 포함 – 다운로드용)
    AttachmentDTO selectAttachmentById(Long id);

    // 첨부파일 삭제
    void deleteAttachment(Long id);

    // 게시글에 속한 모든 첨부파일 삭제
    void deleteAttachmentsByBoardId(Long boardId);
}
