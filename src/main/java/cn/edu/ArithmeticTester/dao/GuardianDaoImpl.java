package cn.edu.ArithmeticTester.dao;

import cn.edu.ArithmeticTester.entity.Guardian;
import cn.edu.ArithmeticTester.entity.Student;
import cn.edu.ArithmeticTester.entity.User;
import cn.edu.ArithmeticTester.utils.DataBaseTools;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 家长端的Dao类
 * @author prinz
 */
public class GuardianDaoImpl implements UserDao{
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
            String sql = "SELECT * FROM guardian WHERE id = '"+ user +"' AND pwd = '"+password+"'";
            System.out.println(sql);
            resultSet = statement.executeQuery(sql);
            //如果可以获取，则包装获取到的家长类
            if (resultSet.next()){
                String getUser = resultSet.getString(1);
                String getName = resultSet.getString(2);
                String getPassword = resultSet.getString(3);
                return new Guardian(getUser, getName, getPassword);
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
    public int addUser(String user, String name,String password) {
        try {
            //连接数据库
            Class.forName(DataBaseTools.DRIVER_CLASS);
            connection = DriverManager.getConnection(DataBaseTools.CONNECT_STR, DataBaseTools.USER, DataBaseTools.PASSWORD);
            statement = connection.createStatement();
            //执行添加语句
            String sql = "INSERT INTO guardian VALUES('"+user+"', '"+name+"', '"+password+"')";
            System.out.println(sql);
            //返回结果
            return statement.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 仅用于学生账户，在家长Dao类不使用
     * @param user  识别学员用户的唯一用户名
     * @param name  学员姓名（可以重名）
     * @param password  学员用户密码
     * @param guardianUser  用于验证家长账户的家长用户名
     * @param guardianPassword  对应的家长用户密码
     * @return 0
     */
    @Override
    public int addUserWithGuardian(String user, String name,String password, String guardianUser, String guardianPassword) {
        return 0;
    }

    @Override
    public ArrayList<User> getUsersWithGuardian(String guardian) {
        try {
            //连接数据库
            Class.forName(DataBaseTools.DRIVER_CLASS);
            connection = DriverManager.getConnection(DataBaseTools.CONNECT_STR, DataBaseTools.USER, DataBaseTools.PASSWORD);
            statement = connection.createStatement();
            /*执行家长账户绑定的学生账户的查询语句*/
            String sqlSt = "SELECT * FROM child WHERE guardian = '"+guardian+"' ";
            resultSet = statement.executeQuery(sqlSt);
            System.out.println(sqlSt);
            ArrayList<User> studentList = new ArrayList();
            //没有找到绑定的学生账户返回null
            if (!resultSet.next()){
                return null;
            }
            //包装得到的学生类
            do{
                String studentUserName = resultSet.getString(1);
                String studentName = resultSet.getString(2);
                String studentPassword = resultSet.getString(3);
                String guardianUser = guardian;

                Student student = new Student(studentUserName, studentName, studentPassword, guardianUser);
                //添加进学生列表
                studentList.add(student);
            }while(resultSet.next());
            return studentList;
             } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
