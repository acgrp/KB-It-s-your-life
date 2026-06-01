package org.scoula.jdbc_ex.temp;

import java.sql.*;

public class JDBCEx1 {

    public static void main(String[] args) {

        // JDBC : java와 DB를 연결할 수 있게 해주는 java API

        // [1단계] : JDBC 객체 참조 변수 선언(java.sql 패키지)

        Connection conn = null;

        Statement stmt = null;
        // Connection 객체를 통해
        // Java에서 작성된 SQL을 DB로 전달
        // 결과를 반환 받아 다시 Java로 돌아오는 역할의 객체

        ResultSet rs = null;
        // SELECT 질의 성공 시 반환되는
        // 결과 행의 집합(Result Set)을 나타내는 객체

        try{
            // [2단계] 참조변수에 알맞은 객체 대입하기

            // 1. DB 연결에 필요한 MySQL JDBC Driver 메모리 로드하기
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. 연결 정보를 담은 Connection 생성
            // DriverManager : JDBC 드라이버를 통해 Connection 객체 만드는 역할
            String url = "jdbc:mysql://localhost:3306/jdbc_ex";
            String id = "scoula";
            String password = "1234";

            conn = DriverManager.getConnection(url, id, password);
//            System.out.println(conn);
            //com.mysql.cj.jdbc.ConnectionImpl@4988d8b8



            // 3. Statement 객체에 적재할 SQL 작성
            String sql = "SELECT * FROM users";

            // 4. Statement 객체 생성
            stmt = conn.createStatement();

            // 5. SQL을 Statement에 적재 후 DB로 전달하여
            //      수행한 후 결과를 반환 받아와 rs변수에 대입
            rs = stmt.executeQuery(sql);

            // [3단계]
            while(rs.next()){
                //rs.next() : 참조하고 있는 ResultSet 객체의
                // 첫 번째 컬럼부터 순서대로 한 행씩 이동하며
                // 다음 행이 있을 경우 true 반환

                // rs.get[Type]("컬럼명")
                String userId = rs.getString("ID");
                System.out.println(userId);

                // 이름
                String userName = rs.getString("NAME");
                System.out.println(userName);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // 오류 내용
        } catch (SQLException e) {
            // SQLException : DB 연결 관련 예외의 최상위 부모
            e.printStackTrace(); // 오류 내용
        }finally {
            // [4단계] 사용한 JDBC 객체 자원 반환(close)
            // -> 자원 반환 순서는 객체 생성 순서의 역순

            try {
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
