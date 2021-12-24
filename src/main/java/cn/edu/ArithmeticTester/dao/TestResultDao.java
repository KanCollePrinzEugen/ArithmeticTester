package cn.edu.ArithmeticTester.dao;

import cn.edu.ArithmeticTester.entity.TestResult;
import cn.edu.ArithmeticTester.utils.DataBaseTools;

import java.sql.*;
import java.util.ArrayList;

/**
 * 该类执行查询和存储指定学生的所有练习记录
 * @author prinzeugen
 */
public class TestResultDao {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    /**
     * 存储指定学生的一次练习记录
     * @param forumNum  题目总数
     * @param mistake   错题数
     * @param accuracy  正确率
     * @param studentUserName   学生用户名
     * @return 返回添加结果，大于0添加成功，否则添加失败
     */
    public int addResult(int forumNum, int mistake, double accuracy, String studentUserName){
        try {
            //连接数据库
            Class.forName(DataBaseTools.DRIVER_CLASS);
            connection = DriverManager.getConnection(DataBaseTools.CONNECT_STR, DataBaseTools.USER, DataBaseTools.PASSWORD);
            statement = connection.createStatement();
            //执行添加语句
            String sql = "INSERT INTO testResult(forumNum, mistake, accuracy, stuUser) VALUES("+forumNum+", "+mistake+", "+accuracy+", '"+studentUserName+"')";
            System.out.println(sql);
            //返回添加结果
            return statement.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取指定学生的所有练习结果
     * @param studentUserName 练习者用户名
     * @return 返回结果类的ArrayList，若获取失败则返回null
     */
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
            boolean result = resultSet.next();
            ArrayList<TestResult> results = new ArrayList<>();
            //没有查询结果返回null
            if(!result){
                return null;
            }
            /*包装查询结果为结果类*/
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
