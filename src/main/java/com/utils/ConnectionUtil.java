package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @Auther: 张扬
 * @Date: 2018/11/2 13:49
 * @Description:
 */
public class ConnectionUtil {
    public static final String URL = "jdbc:mysql://10.35.0.21:3306/dmr?autoReconnect=true&useUnicode=true&zeroDateTimeBehavior=convertToNull&characterEncoding=UTF-8";
    public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    public static final String USER_NAME = "bigdata_query";
    public static final String PASSWORD = "vPMZ&2z&BuvuWPES";

    public static  Connection conn = null;
    public PreparedStatement pst = null;

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER_NAME);//指定连接类型
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);//获取连接
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

//    public static  void close() {
//        try {
//            this.conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


}
