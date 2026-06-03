package org.edu.member.vo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Member {

    private int no;
    private String id;
    private String pw;
    private String name;
    private String role;
    private char deleted_yn;

    public Member(String id, String pw, String name, String role) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.role = role;
    }
}
