package com.caicy.pattern.template.jdbc;

import sun.security.util.Password;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Properties;

public class DBTool {
    private static String DRIVER_CLASS ;
    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;
    private static Properties properties;


    static {
        InputStream in = DBTool.class.getClassLoader().getResourceAsStream("db.properties");
        Properties p = new Properties();
        try {
            p.load(in);
            Class.forName(p.getProperty("driverClass"));
            URL = p.getProperty("url");
            USERNAME = p.getProperty("username");
            PASSWORD = p.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动程序类 ，加载驱动失败！");
            e.printStackTrace() ;
        }
        properties = p;

    }


    public static void execute(String sql, Object [] args){
        try {

            //在一个应用中 123 567这些步骤是重复的
            //1、获取连接
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            //2、创建语句集
            //预编译语句
            PreparedStatement statement = connection.prepareStatement(sql);
            //3、执行语句集，并且获得结果集
            if(null != args){
                for(int i = 1; i <args.length; i++){
                    statement.setObject(i,args[i]);
                }
            }

            ResultSet resultSet = statement.executeQuery();

            //4、解析结果集
            while(resultSet.next()){
                resultSet.getInt("id");
                resultSet.getString("username");
            }

            //5、关闭结果集
            resultSet.close();
            //6、关闭语句集
            statement.close();
            //7、关闭连接
            connection.close();


        }catch (Exception e){
            e.printStackTrace();
        }
        

    }


}
