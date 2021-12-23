package cn.edu.ArithmeticTester.dao;

import cn.edu.ArithmeticTester.entity.Student;
import cn.edu.ArithmeticTester.entity.User;
import cn.edu.ArithmeticTester.utils.DataBaseTools;

import java.sql.*;

/**
 * @author prinzeugen
 */
public class StudentDaoImpl implements UserDao{
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    @Override
    public User getUser(String user, String password) {
        try {
            //连接数据库
            Class.forName(DataBaseTools.DRIVER_CLASS);
            connection = DriverManager.getConnection(DataBaseTools.CONNECT_STR, DataBaseTools.USER, DataBaseTools.PASSWORD);
            statement = connection.createStatement();
            //执行查询语句
            String sql = "SELECT * FROM child WHERE id = '"+ user +"' AND pwd = + '"+password+"'";
            System.out.println(sql);
            resultSet = statement.executeQuery(sql);
            //如果可以获取，则包装获取到的学生类
            if (resultSet.next()){
                String getUser = resultSet.getString(1);
                String getName = resultSet.getString(2);
                int getPassword = resultSet.getInt(3);
                String getGuardian = resultSet.getString(4);

                return new Student(getUser, getName, getPassword, getGuardian);
            } else {
                //无法获取返回空值
                return null;
            }
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addUserWithGuardian(String user, String name,String password, String guardianUser, String guardianPassword) {
        try {
            //连接数据库
            Class.forName(DataBaseTools.DRIVER_CLASS);
            connection = DriverManager.getConnection(DataBaseTools.CONNECT_STR, DataBaseTools.USER, DataBaseTools.PASSWORD);
            statement = connection.createStatement();
            //执行添加语句
            String sql = "SELECT * FROM guardian WHERE id = '"+ guardianUser +"' AND pwd = '"+guardianPassword+"'";
            resultSet = statement.executeQuery(sql);
            System.out.println(sql);
            if (resultSet.next()) {
                sql = "INSERT INTO child VALUES('"+user+"', '"+name+"', '"+password+"', '"+guardianUser+"')";
                System.out.println(sql);
                return statement.executeUpdate(sql);
            } else {
                return 0;
            }
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int addUser(String user, String name, String password) {
        return 0;
    }
}
