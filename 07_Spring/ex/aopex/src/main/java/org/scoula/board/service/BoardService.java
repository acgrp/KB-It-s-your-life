package org.scoula.board.service;

import org.scoula.board.dto.AttachmentDTO;
import org.scoula.board.dto.BoardDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BoardService {
    List<BoardDTO> getList();
    BoardDTO get(Long id);
    BoardDTO create(BoardDTO board, List<MultipartFile> files) throws IOException;
    BoardDTO update(BoardDTO board, List<MultipartFile> files) throws IOException;
    void delete(Long id);

    // 첨부파일 단건 조회 (다운로드용 – BLOB 포함)
    AttachmentDTO getAttachment(Long attachId);

    // 첨부파일 단건 삭제
    void deleteAttachment(Long attachId);
}
