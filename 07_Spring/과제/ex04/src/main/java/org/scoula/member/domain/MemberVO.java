package org.scoula.member.domain;

import lombok.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MemberVO {
    private Long no;
    private String username;
    private String password;
    private String email;
    private Integer birthYear;
    private Date regDate;
    private Date updatedDate;
}