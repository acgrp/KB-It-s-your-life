package org.scoula.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data  // getter setter tostring
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 전체 생성자
@Builder //
public class BoardVO {

    private long no;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private Date updateDate;
}
