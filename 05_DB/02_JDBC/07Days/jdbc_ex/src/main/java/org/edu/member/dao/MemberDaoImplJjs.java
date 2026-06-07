package org.edu.member.dao;

import org.edu.member.common.JDBCUtil;
import org.edu.member.vo.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDaoImplJjs implements MemberDao {

    private Connection conn = JDBCUtil.getConnection();

    @Override
    public int create(Member m) throws SQLException {

        String sql = "INSERT INTO members VALUES (default, ?, ?, ? ,?, 'Y')";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            conn.setAutoCommit(false);

            pstm.setString(1, m.getId());
            pstm.setString(2, m.getPw());
            pstm.setString(3, m.getName());
            pstm.setString(4, m.getRole());

            int result = pstm.executeUpdate();

            if (result > 0) conn.commit();

            return result;
        }

    }

    @Override
    public void selectAll() throws SQLException {

        String sql = "SELECT * FROM members";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int no = rs.getInt("no");
                String name = rs.getString("name");
                System.out.println("번호: " + no + " | 이름 : " + name);
            }

        }
    }

    @Override
    public int select(Member m) throws SQLException {
        String sql = "SELECT * FROM members WHERE no = ?";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setInt(1, m.getNo());

            try (ResultSet rs = pstm.executeQuery()) {
                boolean found = false;

                while (rs.next()) {
                    found = true;
                    int no = rs.getInt("no");
                    String name = rs.getString("name");
                    System.out.println("번호: " + no + " | 이름: " + name);
                }
                if (!found) {
                    System.out.println("없는 회원 번호입니다.");
                }
            }
        }
        return 0;
    }

    @Override
    public int update(Member m) throws SQLException {
        String sql = "UPDATE members SET name = ?, role = ? WHERE no = ?";
        conn.setAutoCommit(false);

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, m.getName());
            pstm.setString(2, m.getRole());
            pstm.setInt(3, m.getNo());


            int result = pstm.executeUpdate();
            if (result > 0) conn.commit();
            return result;

        }

    }

    @Override
    public int delete(Member m) throws SQLException {

        String sql = "DELETE FROM members WHERE no = ?";
        conn.setAutoCommit(false);

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, m.getNo());


            int result = pstm.executeUpdate();
            if (result > 0) conn.commit();
            return result;
        }
    }

    @Override
    public void getDeptName(Member m) throws SQLException {

        String sql = "select m.no 회원번호, m.name 회원이름, d.dept_no 부서코드, d.dept_name 부서이름 from members m join departments d on m.dept_no = d.dept_no where m.no = ?";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            System.out.println(m.getNo());

            pstm.setInt(1, m.getNo());


            try (ResultSet rs = pstm.executeQuery()) {
                boolean found = false;

                while (rs.next()) {
                    int no = rs.getInt("회원번호");
                    String name = rs.getString("회원이름");
                    int deptNo = rs.getInt("부서코드");
                    String deptName = rs.getString("부서이름");
                    System.out.println("번호: " + no + " | 이름: " + name + " | 부서번호 : " + deptNo + " | 부서이름 : " + deptName);

                    if (!found) {
                        System.out.println("없는 회원 번호입니다.");
                    }
                }
            }

        }
    }
}
