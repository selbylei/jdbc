package com.selbylei.jdbc;

import com.selbylei.jdbc.dao.UserDao;
import com.selbylei.jdbc.dao.impl.UserDaoImpl;
import com.selbylei.jdbc.entetity.User;
import com.selbylei.jdbc.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by selbylei on 16/12/26.
 */
public class UserDaoTest {

    public static void main(String[] args) {
        ConnectionFactory factory = ConnectionFactory.getInstance();
        Connection  connection = factory.makeConnection();
        try {
            connection.setAutoCommit(false);
            UserDao userDao = new UserDaoImpl();
            User tom = new User();
            tom.setName("tom");
            tom.setPassword("123456");
            tom.setEmail("tom@gmail.com");
            userDao.save(connection,tom);
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }
}
