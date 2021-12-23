package cn.edu.ArithmeticTester.dao;

import cn.edu.ArithmeticTester.entity.TestResult;
import cn.edu.ArithmeticTester.utils.DataBaseTools;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author prinzeugen
 */
public class TestResultDao {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public int addResult(int testId, int forumNum, int mistake, double accuracy, String studentUserName){
        try {
            //连接数据库
            Class.forName(DataBaseTools.DRIVER_CLASS);
            connection = DriverManager.getConnection(DataBaseTools.CONNECT_STR, DataBaseTools.USER, DataBaseTools.PASSWORD);
            statement = connection.createStatement();
            //执行添加语句
            String sql = "INSERT INTO testResult(forumNum, mistake, accuracy, stuUser) VALUES("+forumNum+", "+mistake+", "+accuracy+", '"+studentUserName+"')";
            System.out.println(sql);
            return statement.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<TestResult> getResult(String studentUserName){
        try {
            //连接数据库
            Class.forName(DataBaseTools.DRIVER_CLASS);
            connection = DriverManager.getConnection(DataBaseTools.CONNECT_STR, DataBaseTools.USER, DataBaseTools.PASSWORD);
            statement = connection.createStatement();
            /*执行查询语句*/
            String sqlSt = "SELECT * FROM testResult WHERE stuUser = '"+studentUserName+"'";
            resultSet = statement.executeQuery(sqlSt);
            System.out.println(sqlSt);
            /*返回查询结果并包装为学生类*/
            boolean result = resultSet.next();
            ArrayList<TestResult> results = new ArrayList<>();
            if(!result){
                return null;
            }
            do {
                int id = resultSet.getInt(1);
                int forumNum = resultSet.getInt(2);
                int mistake = resultSet.getInt(3);
                double accuracy = resultSet.getDouble(4);
                results.add(new TestResult(id, forumNum, mistake, accuracy, studentUserName));
            } while(resultSet.next());
            return results;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
