package edu.employee.dao;

import edu.common.JDBCUtil;
import edu.employee.vo.EmployeeVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDaoImpl implements EmployeeDao {

    private Connection conn = JDBCUtil.getConnection();

    @Override
    public void selectDeptTitle(EmployeeVO e) throws SQLException {

        String sql = "SELECT EMP_NAME  사원명,\n" +
                "       DEPT_CODE 부서명,\n" +
                "       JOB_CODE  직급명,\n" +
                "       CASE\n" +
                "           WHEN BONUS IS NULL THEN '보너스 없음'\n" +
                "           ELSE BONUS\n" +
                "           END   보너스율,\n" +
                "       CASE ENT_YN\n" +
                "           WHEN 'N' THEN '재직'\n" +
                "           WHEN 'Y' THEN '퇴사'\n" +
                "           END   재직여부\n" +
                "FROM employee e\n" +
                "         JOIN department d ON e.DEPT_CODE = d.DEPT_ID\n" +
                "WHERE d.DEPT_TITLE = ?" +
                " order by BONUS";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, e.getDeptTitle());

            try (ResultSet rs = pstm.executeQuery()) {

                boolean found = false;

                while (rs.next()) {
                    found = true;
                    String empName = rs.getString("사원명");
                    String deptTitle = rs.getString("부서명");
                    String jobName = rs.getString("직급명");
                    String bonus = rs.getString("보너스율");
                    String entYn = rs.getString("재직여부");
                    System.out.println("사원명 : " + empName +
                            " | 부서명 : " + deptTitle +
                            " | 직급명 : " + jobName +
                            " | 보너스율 : " + bonus +
                            " | 재직여부 : " + entYn);
                }
                if (!found) System.out.println("잘못된 부서명이거나 해당 부서에 직원이 없습니다.");
            }
        }
    }

    @Override
    public void selectSalary() throws SQLException {

        String sql = "select d.DEPT_TITLE 부서명, " +
                "j.JOB_NAME 직급명, " +
                "count(*) 사원수, " +
                "ROUND(avg(e.SALARY)) 평균급여  " +
                "from employee e\n" +
                "join department d on e.DEPT_CODE = d.DEPT_ID\n" +
                "join job j on e.JOB_CODE = j.JOB_CODE\n" +
                "where e.ENT_DATE is null\n" +
                "group by DEPT_TITLE, JOB_NAME\n" +
                "having avg(e.SALARY) >= 3000000\n" +
                "ORDER BY 평균급여 DESC";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {

            try (ResultSet rs = pstm.executeQuery()) {
                boolean found = false;

                while (rs.next()) {
                    found = true;
                    String deptTitle = rs.getString("부서명");
                    String jobName = rs.getString("직급명");
                    int count = rs.getInt("사원수");
                    int avg = rs.getInt("평균급여");

                    System.out.println("부서명 : " + deptTitle +
                            " | 직급명 : " + jobName +
                            " | 사원수 : " + count +
                            " | 평균급여 : " + avg);
                }
                if (!found) System.out.println("잘못된 부서명이거나 해당 부서에 직원이 없습니다.");
            }
        }

    }

    @Override
    public void selectEntDate() throws SQLException {

        String sql = "select d.DEPT_TITLE 부서명, j.JOB_NAME 직급명, e.EMP_NAME 사원명, e.SALARY from employee e\n" +
                "join job j on e.JOB_CODE = j.JOB_CODE\n" +
                "left join department d on e.DEPT_CODE = d.DEPT_ID\n" +
                "where e.ENT_DATE is null\n" +
                "order by JOB_NAME\n" +
                "limit 10";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {

            try (ResultSet rs = pstm.executeQuery()) {
                boolean found = false;

                while (rs.next()) {
                    found = true;
                    String deptTitle = rs.getString("부서명");
                    String jobName = rs.getString("직급명");
                    String empName = rs.getString("사원명");
                    int salary = rs.getInt("급여");

                    System.out.println("부서명 : " + deptTitle +
                            " | 직급명 : " + jobName +
                            " | 사원명 : " + empName +
                            " | 급여 : " + salary);
                }
                if (!found) System.out.println("잘못된 부서명이거나 해당 부서에 직원이 없습니다.");
            }
        }
    }

    @Override
    public void increaseSalary(EmployeeVO em) throws SQLException {

        String sql = "update employee set SALARY = SALARY*1.1 where DEPT_CODE = ?";
        conn.setAutoCommit(false);

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, em.getDeptCode());

            int result = pstm.executeUpdate();

            if (result > 0) {
                conn.commit();
                System.out.println(result + "명의 급여가 10% 인상되었습니다.");
            } else {
                conn.rollback();
                System.out.println("잘못된 입력입니다.");
            }

        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }

    @Override
    public void getEmployeesWithoutPhone() throws SQLException {

        String sql = "select e.EMP_NAME 사원명, case when PHONE IS NULL THEN '없음' ELSE PHONE END 휴대폰번호, d.DEPT_TITLE 부서명\n" +
                "from employee e\n" +
                "join department d on e.DEPT_CODE = d.DEPT_ID\n" +
                "where PHONE is null\n" +
                "order by EMP_NAME";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {

            try (ResultSet rs = pstm.executeQuery()) {
                boolean found = false;

                while (rs.next()) {
                    found = true;
                    String empName = rs.getString("사원명");
                    String phone = rs.getString("휴대폰번호");
                    String deptName = rs.getString("부서명");

                    System.out.println("사원명 : " + empName +
                            " | 휴대폰번호 : " + phone +
                            " | 부서명 : " + deptName);
                }
                if (!found) System.out.println("일치하는 항목이 없습니다.");
            }

        }
    }
}
