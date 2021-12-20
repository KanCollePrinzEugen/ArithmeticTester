package cn.edu.ArithmeticTester.dao;

import cn.edu.ArithmeticTester.entity.Guardian;
import cn.edu.ArithmeticTester.entity.User;
import cn.edu.ArithmeticTester.utils.DataBaseTools;

import java.sql.*;

/**
 * @author prinz
 */
public class GuardianDaoImp implements UserDao{
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
            String sql = "SELECT * FROM guardian WHERE id = '"+ user +"' AND pwd = + '"+password+"'";
            System.out.println(sql);
            resultSet = statement.executeQuery(sql);
            //如果可以获取，则包装获取到的家长类
            if (resultSet.next()){
                String getUser = resultSet.getString(1);
                String getName = resultSet.getString(2);
                int getPassword = resultSet.getInt(3);

                Guardian guardian = new Guardian(getUser, getName, getPassword);
                return guardian;
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
    public int addUser(String user, String name, String password) {
        try {
            //连接数据库
            Class.forName(DataBaseTools.DRIVER_CLASS);
            connection = DriverManager.getConnection(DataBaseTools.CONNECT_STR, DataBaseTools.USER, DataBaseTools.PASSWORD);
            statement = connection.createStatement();
            //执行添加语句
            String sql = "INSERT INTO guardian VALUES("+user+", '"+name+"', '"+password+"')";
            System.out.println(sql);
            return statement.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}
