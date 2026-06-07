package org.edu.member.dao;

import org.edu.member.common.JDBCUtil;
import org.edu.member.vo.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDaoImpl implements MemberDao{

    // JDBCUtil을 통해 Connection 객체 가져오기
    private Connection conn = JDBCUtil.getConnection();

    // 회원 등록
    @Override
    public int create(Member m) throws SQLException {

        //PreparedStatement
        // - Statement의 자식으로 좀 더 향상된 기능을 제공
        // - ?(위치 홀더)를 이용하여 SQL에 작석되어지는 리터럴을 동적으로 제어
        // -> 오타 위험 감소, 가독성 상승

        // sql문 작성 시 세미콜론(;)은 안쓰는 것이 관례

        String sql = "INSERT INTO members VALUES (default, ?, ?, ?, ?, 'Y')";

        // try-with-resources문을 사용하여 작업이 끝나면 close()가 자동 호출됨
        try(PreparedStatement pstm = conn.prepareStatement(sql)){
            conn.setAutoCommit(false);

            pstm.setString(1, m.getId());
            pstm.setString(2, m.getPw());
            pstm.setString(3, m.getName());
            pstm.setString(4, m.getRole());

            // SELECT : executeQuery(); -> ResultSet 반환
            // DML    : executeUpdate(); -> 성공한 행의 개수 반환
            int result = pstm.executeUpdate();

            // 성공 시 커밋
            if(result > 0) conn.commit();

            return result; // 성공한 행의 개수 반환

        }
    }

    @Override
    public int update(Member m) throws SQLException {

        String sql = "update members set name = ?, role = ? where no = ?";

        try(PreparedStatement pstm = conn.prepareStatement(sql)){
            conn.setAutoCommit(false);

            pstm.setString(1, m.getName());
            pstm.setString(2, m.getRole());
            pstm.setInt(3, m.getNo());

            int result = pstm.executeUpdate();

            if(result > 0) conn.commit();

            return result;
        }

    }

    @Override
    public int select(Member findMember) throws SQLException {

        String sql = "select * from members where no = ?";

        try(PreparedStatement pstm = conn.prepareStatement(sql)){
            conn.setAutoCommit(false);

            pstm.setInt(1, findMember.getNo());

            try(ResultSet rs = pstm.executeQuery()){
                if(rs.next()) return rs.getInt(1);

            }
        }
        return 0;
    }

    @Override
    public int delete(Member m) throws SQLException {

        String sql = "delete from members where no = ?";

        try(PreparedStatement pstm = conn.prepareStatement(sql)){
            conn.setAutoCommit(false);

            pstm.setInt(1, m.getNo());

            int result = pstm.executeUpdate();

            if(result > 0) conn.commit();

            return result;
        }
    }

    @Override
    public void getDeptName(Member m) throws SQLException {
        String sql = "select m.no, m.name, d.dept_no, d.dept_name from members m join departments d on m.dept_no = d.dept_no where m.no = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, m.getNo());

            try (ResultSet rs = pstmt.executeQuery()) {

                if(rs.next()){
                    // no == pk == 조회시 1행

                    Member mem = new Member();
                    mem.setNo(rs.getInt("no"));
                    mem.setName(rs.getString("name"));
                    mem.setDeptNo(rs.getInt("dept_no"));
                    mem.setDeptName("dept_name");


                }

            }


        }
    }

    @Override
    public void selectAll() throws SQLException {

    }

}
