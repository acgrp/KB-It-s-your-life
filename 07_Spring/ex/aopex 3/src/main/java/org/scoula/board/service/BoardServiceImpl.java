package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scoula.board.dto.AttachmentDTO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public List<BoardDTO> getList() {
        List<BoardDTO> boards = boardMapper.selectAll();
        // 각 게시글마다 첨부파일 메타 정보(BLOB 제외) 조회
        boards.forEach(b -> b.setAttachments(boardMapper.selectAttachmentsByBoardId(b.getId())));
        return boards;
    }

    @Override
    public BoardDTO get(Long id) {
        BoardDTO board = boardMapper.selectById(id);
        if (board != null) {
            board.setAttachments(boardMapper.selectAttachmentsByBoardId(id));
        }
        return board;
    }

    /**
     * 게시글 등록 + 첨부파일 BLOB 저장
     * 트랜잭션: 게시글 insert 와 파일 insert 를 하나의 단위로 묶음
     */
    @Override
    @Transactional
    public BoardDTO create(BoardDTO board, List<MultipartFile> files) throws IOException {
        boardMapper.insert(board);          // 게시글 저장 → board.id 자동 주입
        saveAttachments(board.getId(), files);
        return get(board.getId());
    }

    /**
     * 게시글 수정 + 첨부파일 추가
     * 기존 파일은 유지하고, 새로 선택한 파일만 추가 업로드
     */
    @Override
    @Transactional
    public BoardDTO update(BoardDTO board, List<MultipartFile> files) throws IOException {
        boardMapper.update(board);
        saveAttachments(board.getId(), files);
        return get(board.getId());
    }

    /**
     * 게시글 삭제 (첨부파일도 함께 삭제 – CASCADE 또는 명시 삭제)
     */
    @Override
    @Transactional
    public void delete(Long id) {
        boardMapper.deleteAttachmentsByBoardId(id);  // BLOB 데이터 먼저 삭제
        boardMapper.delete(id);
    }

    /**
     * 첨부파일 단건 조회 – BLOB 포함 (다운로드 전용)
     */
    @Override
    public AttachmentDTO getAttachment(Long attachId) {
        return boardMapper.selectAttachmentById(attachId);
    }

    /**
     * 첨부파일 단건 삭제
     */
    @Override
    @Transactional
    public void deleteAttachment(Long attachId) {
        boardMapper.deleteAttachment(attachId);
    }

    // ──── 내부 헬퍼 ────

    /**
     * MultipartFile 리스트를 읽어 BLOB으로 DB에 저장
     */
    private void saveAttachments(Long boardId, List<MultipartFile> files) throws IOException {
        if (files == null) return;
        for (MultipartFile file : files) {
            if (file == null || file.isEmpty()) continue;

            AttachmentDTO attach = new AttachmentDTO();
            attach.setBoardId(boardId);
            attach.setFilename(file.getOriginalFilename());
            attach.setContentType(file.getContentType());
            attach.setFileSize(file.getSize());
            attach.setFileData(file.getBytes());  // ← MultipartFile → byte[] → BLOB

            boardMapper.insertAttachment(attach);
            log.info("첨부파일 BLOB 저장: boardId={}, filename={}, size={}bytes",
                    boardId, attach.getFilename(), attach.getFileSize());
        }
    }
}
