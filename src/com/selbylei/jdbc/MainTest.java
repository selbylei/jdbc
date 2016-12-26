package com.selbylei.jdbc;

import com.selbylei.jdbc.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by selbylei on 16/12/26.
 */
public class MainTest {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = ConnectionFactory.getInstance();
        Connection conn = factory.makeConnection();
        System.out.println(conn.getAutoCommit());
    }
}
