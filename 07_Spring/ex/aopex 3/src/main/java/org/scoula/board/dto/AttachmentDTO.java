package org.scoula.board.dto;

import lombok.Data;

@Data
public class AttachmentDTO {
    private Long id;          // PK
    private Long boardId;     // 게시글 ID (FK)
    private String filename;  // 원본 파일명
    private String contentType; // MIME type
    private long fileSize;    // 파일 크기 (bytes)
    private byte[] fileData;  // BLOB 데이터 (업로드/다운로드 시 사용)
}
