package org.scoula.member.mapper;

import org.scoula.member.domain.MemberVO;
import java.util.List;

public interface MemberMapper {

    // Create (등록)
    void insert(MemberVO member);

    // Read (전체 조회)
    List<MemberVO> getList();

    // Read (단건 조회)
    MemberVO read(Long no);

    // Delete (삭제)
    int delete(Long no);

    // Update (수정)
    int update(MemberVO member);
}