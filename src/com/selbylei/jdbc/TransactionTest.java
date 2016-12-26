package com.selbylei.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by selbylei on 16/12/26.
 * <p/>
 * 事务处理
 */
public class TransactionTest {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            insertUserData(conn);
            insertAddressData(conn);
            conn.commit();
        } catch (SQLException e) {
            System.out.println("======捕获sql异常======");
            e.printStackTrace();
            try {
                conn.rollback();
                System.out.println("=====事务回滚成功=====");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //获取数据库链接
    public static Connection getConnection() {
        Connection conn = null;
        //打开链接
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }


    //向user表插入数据
    public static void insertUserData(Connection conn) throws SQLException {
        String sql = "INSERT INTO tbl_user(id,name,password,email)" +
                "VALUES (10,'Tom','123456','tom@gmail.com')";
        Statement st = conn.createStatement();
        int count = st.executeUpdate(sql);
        System.out.println("向用户表中插入了" + count + " 条纪录");
    }

    //向地址表插入数据
    public static void insertAddressData(Connection conn) throws SQLException {
        String sql = "INSERT INTO tbl_address(city, country, user_id) " +
                "VALUES ('上海','china','10')";
        Statement st = conn.createStatement();
        int count = st.executeUpdate(sql);
        System.out.println("向地址表中插入了" + count + " 条纪录");
    }
}
