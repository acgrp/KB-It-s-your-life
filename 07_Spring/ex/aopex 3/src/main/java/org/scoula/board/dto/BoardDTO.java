package org.scoula.board.dto;

import lombok.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class BoardDTO {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private Date updateDate;

    // 첨부파일 목록 (파일 데이터 제외한 메타정보)
    private List<AttachmentDTO> attachments = new ArrayList<>();
}
