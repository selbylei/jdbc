package com.selbylei.jdbc.dao.impl;

import com.selbylei.jdbc.dao.UserDao;
import com.selbylei.jdbc.entetity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by selbylei on 16/12/26.
 */
public class UserDaoImpl implements UserDao {

    //保存方法
    @Override
    public void save(Connection conn, User user) throws SQLException {
        PreparedStatement ps = conn.prepareCall("INSERT INTO tbl_user(name,password,email) VALUES (?,?,?)");
        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.execute();
    }

    //更新方法
    @Override
    public void update(Connection connection, Long id, User user) throws SQLException {
        String sql = "UPDATE tbl_user SET name=?,password=?,email=?,id=?";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.setLong(4, user.getId());
        ps.execute();
    }

    //删除方法
    @Override
    public void delete(Connection connection, User user) throws SQLException {
        String sql = "DELETE tbl_user WHERE id=?";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setLong(1, user.getId());
        ps.execute();
    }
}
