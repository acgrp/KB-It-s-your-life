package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import org.scoula.board.dto.AttachmentDTO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    /** 게시글 목록 (첨부파일 메타 포함, BLOB 제외) */
    @GetMapping("")
    public List<BoardDTO> list() {

        List<BoardDTO> list = boardService.getList();
        System.out.println(list);
        return list;
    }

    /** 게시글 단건 조회 */
    @GetMapping("/{id}")
    public BoardDTO get(@PathVariable Long id) {
        return boardService.get(id);
    }

    /**
     * 게시글 등록 + 첨부파일 업로드 (BLOB 저장)
     *
     * multipart/form-data 로 전송:
     *   - title, content, writer  → 텍스트 파트
     *   - files[]                 → 파일 파트 (0개 이상)
     */
    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<BoardDTO> create(
            @RequestPart("title")   String title,
            @RequestPart("content") String content,
            @RequestPart("writer")  String writer,
            @RequestPart(value = "files", required = false) List<MultipartFile> files
    ) throws IOException {

        BoardDTO board = new BoardDTO();
        board.setTitle(title);
        board.setContent(content);
        board.setWriter(writer);

        BoardDTO created = boardService.create(board, files);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /**
     * 게시글 수정 + 추가 첨부파일 업로드
     */
    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public BoardDTO update(
            @PathVariable Long id,
            @RequestPart("title")   String title,
            @RequestPart("content") String content,
            @RequestPart(value = "files", required = false) List<MultipartFile> files
    ) throws IOException {

        BoardDTO board = new BoardDTO();
        board.setId(id);
        board.setTitle(title);
        board.setContent(content);

        return boardService.update(board, files);
    }

    /** 게시글 삭제 (첨부파일 BLOB 포함) */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        boardService.delete(id);
    }

    // ──── 첨부파일 ────

    /**
     * 첨부파일 다운로드
     * DB의 BLOB 컬럼을 읽어 바이트 스트림으로 응답 – 파일 시스템 불필요
     */
    @GetMapping("/attach/{attachId}")
    public ResponseEntity<byte[]> download(@PathVariable Long attachId)
            throws UnsupportedEncodingException {

        AttachmentDTO attach = boardService.getAttachment(attachId);
        if (attach == null || attach.getFileData() == null) {
            return ResponseEntity.notFound().build();
        }

        // 한글 파일명 깨짐 방지
        String encodedFilename = URLEncoder.encode(attach.getFilename(), "UTF-8")
                .replaceAll("\\+", "%20");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(
                attach.getContentType() != null ? attach.getContentType()
                                                : "application/octet-stream"));
        headers.setContentLength(attach.getFileSize());
        headers.set(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + encodedFilename + "\"");

        return ResponseEntity.ok()
                .headers(headers)
                .body(attach.getFileData());   // ← BLOB byte[] 를 그대로 반환
    }

    /** 첨부파일 단건 삭제 */
    @DeleteMapping("/attach/{attachId}")
    public void deleteAttachment(@PathVariable Long attachId) {
        boardService.deleteAttachment(attachId);
    }
}
