package org.scoula.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.board.domain.BoardVO;

import java.util.Date;
<<<<<<< HEAD

@Data  // getter setter tostring
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 전체 생성자
@Builder //

=======
import java.util.List;


@Data  // getter setter tostring equals hashcode
@NoArgsConstructor  // 기본 생성자
@AllArgsConstructor // 모든 필드 생성자
@Builder // 빌더 패턴
>>>>>>> df685bb1a5adf443dac156cdf1de3d4d441abf52
public class BoardDTO {
    private Long no;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private Date updateDate;

<<<<<<< HEAD
    private long no;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private Date updateDate;

    public static BoardDTO of(BoardVO vo) {
=======
    public static BoardDTO of(BoardVO vo) { // vo -> dto

>>>>>>> df685bb1a5adf443dac156cdf1de3d4d441abf52
        return vo == null ? null : BoardDTO.builder()
                .no(vo.getNo())
                .title(vo.getTitle())
                .content(vo.getContent())
                .writer(vo.getWriter())
                .regDate(vo.getRegDate())
                .updateDate(vo.getUpdateDate())
                .build();
    }
<<<<<<< HEAD

    public BoardVO toVo() {

        return BoardVO.builder()
                .no(no)
                .title(title)
                .content(content)
                .writer(writer)
                .regDate(regDate)
                .updateDate(updateDate)
                .build();
    }
=======
>>>>>>> df685bb1a5adf443dac156cdf1de3d4d441abf52

    public BoardVO toVo(){
        return BoardVO.builder()
                .no(no)
                .title(title)
                .content(content)
                .writer(writer)
                .regDate(regDate)
                .updateDate(updateDate)
                .build();
    }
}

