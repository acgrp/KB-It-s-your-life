package org.edu.member.dao;

import org.edu.member.vo.Member;

import java.sql.SQLException;

public interface MemberDao {


    int create(Member m) throws SQLException;

    void selectAll() throws SQLException;

    void select(Member m) throws SQLException;

    int update(Member m) throws SQLException;

    int delete(Member m) throws SQLException;
}
