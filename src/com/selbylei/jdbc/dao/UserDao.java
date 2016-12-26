package com.selbylei.jdbc.dao;

import com.selbylei.jdbc.entetity.User;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by selbylei on 16/12/26.
 */
public interface UserDao {

    public void save(Connection conn, User user) throws SQLException;

    public void update(Connection connection, Long id, User user) throws SQLException;

    public void delete(Connection connection, User user) throws SQLException;
}
