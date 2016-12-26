package com.selbylei.jdbc.util;

import java.io.IOException;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by selbylei on 16/12/26.
 */
public class ConnectionFactory {
    private static String driver;
    private static String dburl;
    private static String user;
    private static String password;
    private static ConnectionFactory factory = new ConnectionFactory();

    //静态代码块，只执行一次
    static {
        Properties prop = new Properties();
        try {
            InputStream is = ConnectionFactory.class.getClassLoader()
                            .getResourceAsStream("dbconfig.properties");
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("配置文件读取错误");
        }

        driver = prop.getProperty("driver");
        dburl = prop.getProperty("dburl");
        user = prop.getProperty("user");
        password = prop.getProperty("password");
    }


    private ConnectionFactory() {
    }

    public static ConnectionFactory getInstance() {
        return factory;
    }


    //获取数据库链接
    public Connection makeConnection() {
        Connection conn = null;
        //打开链接
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(dburl, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
