package com.test.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.IOException;
import java.util.Properties;

public class DbUtil {
    InputStream  is = DbUtil.class.getResourceAsStream("/conf/jdbc.properties");
    Properties pros = new Properties();
    private boolean flag = false;  //用于记录是否配置数据库
    private String dbUrl;
    private String dbUserName;
    private String dbPassword;
    private String jdbcName;


    /**
     * 配置数据库
     * @throws Exception
     */
    public void conf() throws Exception{
        pros.load(is);
        dbUrl = pros.getProperty("url");
        dbUserName = pros.getProperty("user");
        dbPassword = pros.getProperty("password");
        jdbcName = pros.getProperty("driverClass");
        flag = true;

    }

    /**
     * 获得数据库连接
     * @return Connection
     * @throws Exception
     */
    public Connection getConnection() throws Exception{

        if(!flag) conf();
        Class.forName(jdbcName);
        return DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
    }
    /**
     * 关闭数据库连接
     * @param con
     * @throws Exception
     */
    public void closeCon(Connection con)throws Exception{
        if(con!=null) {
            con.close();
        }
    }
    public static void main(String[] args) {
        DbUtil dbUtil = new DbUtil();
        try {
            dbUtil.getConnection();
            System.out.println("数据库连接成功");
        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }
}