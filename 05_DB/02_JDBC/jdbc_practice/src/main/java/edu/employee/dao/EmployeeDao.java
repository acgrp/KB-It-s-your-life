package edu.employee.dao;

import edu.employee.vo.EmployeeVO;

import java.sql.SQLException;

public interface EmployeeDao {
    void selectDeptTitle(EmployeeVO e) throws SQLException;

    void selectSalary() throws SQLException;

    void selectEntDate() throws SQLException;

    void increaseSalary(EmployeeVO e) throws SQLException;

    void getEmployeesWithoutPhone() throws SQLException;
}
