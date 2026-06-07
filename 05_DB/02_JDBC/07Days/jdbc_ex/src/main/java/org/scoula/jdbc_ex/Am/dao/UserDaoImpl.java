package org.scoula.jdbc_ex.Am.dao;

import org.scoula.jdbc_ex.Am.domain.UserVO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao{

    @Override
    public int create(UserVO user) throws SQLException {
        return 0;
    }

    @Override
    public List<UserVO> getList() throws SQLException {
        return List.of();
    }

    @Override
    public Optional<UserVO> get(String id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public int update(UserVO user) throws SQLException {
        return 0;
    }

    @Override
    public int delete(String id) throws SQLException {
        return 0;
    }
}
