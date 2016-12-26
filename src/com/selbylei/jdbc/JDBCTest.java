package com.selbylei.jdbc;


import java.sql.*;

/**
 * Created by selbylei on 16/12/26.
 */
public class JDBCTest {
    public static void main(String[] args) {
//        select();
//        insert();
//        update();
//        delete();
//        select();

    }

    //查询
    public static void select() {
        String sql = "SELECT * FROM tbl_user";
        Connection conn = getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.print(rs.getInt("id") + " ");
                System.out.print(rs.getString("name") + " ");
                System.out.print(rs.getString("password") + " ");
                System.out.print(rs.getString("email") + "");
                System.out.println();
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //获取数据库链接
    public static Connection getConnection() {
        Connection connection = null;
        //打开链接
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db", "root", "");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }


    //插入数据
    public static void insert() {
        String sql = "INSERT INTO tbl_user(name,password,email)" +
                "VALUES ('Tom','123456','tom@gmail.com')";
        Connection conn = getConnection();
        try {
            Statement st = conn.createStatement();
            int count = st.executeUpdate(sql);
            System.out.println("向用户表中插入了" + count + " 条纪录");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //更新
    public static void update() {
        String sql = "UPDATE tbl_user SET name='selbylei' WHERE name='tom'";
        Connection conn = getConnection();
        try {
            Statement st = conn.createStatement();
            int count = st.executeUpdate(sql);
            System.out.println("向用户表更新了" + count + " 条纪录");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //删除数据
    public static void delete() {
        String sql = "DELETE FROM tbl_user WHERE name='selbylei'";
        Connection conn = getConnection();
        try {
            Statement st = conn.createStatement();
            int count = st.executeUpdate(sql);
            System.out.println("从用户表删除了" + count + " 条纪录");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
