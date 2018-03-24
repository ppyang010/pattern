package com.caicy.pattern.template.mytemplate.typeA;

import com.caicy.pattern.template.jdbc.DBTool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractJdbcTemplateA<T> {


    public  <T> List execute(String sql, Object [] args){
        try {

            //在一个应用中 123 567这些步骤是重复的
            //1、获取连接
            Connection connection = getConnection();

            //2、创建语句集
            //预编译语句
            PreparedStatement statement = getPreparedStatement(sql, connection);
            //3、执行语句集，并且获得结果集
            ResultSet resultSet = executeQuery(statement,args);

            //4、解析结果集
            List list = parseResultSet(resultSet);

            //5、关闭结果集
            closeResultSet(resultSet);
            //6、关闭语句集
            closeStatement(statement);
            //7、关闭连接
            closeConnection(connection);

            return list;


        }catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }

    public  abstract  T rowMap(ResultSet resultSet) throws SQLException ;

    private List parseResultSet(ResultSet resultSet) throws SQLException {
        int rowNum = 1;
        List list =new ArrayList<T>();
        while(resultSet.next()){
            T obj = (T) rowMap(resultSet);
            list.add(obj);
        }
        return list;
    }




    private void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    private void closeStatement(PreparedStatement statement) throws SQLException {
        statement.close();
    }

    private void closeResultSet(ResultSet resultSet) throws SQLException {
        resultSet.close();
    }

    private ResultSet executeQuery( PreparedStatement statement,Object[] args) throws SQLException {
        if(null != args){
            for(int i = 1; i <= args.length; i++){
                statement.setObject(i,args[i-1]);
            }
        }
        return statement.executeQuery();
    }

    private PreparedStatement getPreparedStatement(String sql, Connection connection) throws SQLException {
        return connection.prepareStatement(sql);
    }

    private  Connection getConnection() throws SQLException {
        return DBTool.getConnection();
    }


}
