package cn.edu.ArithmeticTester.dao;

import cn.edu.ArithmeticTester.entity.User;

import java.util.ArrayList;

/**
 * @author prinzeugen
 */
public interface UserDao {
    /**
     * 获取指定的用户信息并包装成用户类
     * 获取前需要和数据库校验用户名和密码
     * 用于登录验证
     * @param user 识别用户的唯一用户名
     * @param password 用户密码
     * @return  登录成功返回相应的用户类，登录失败返回空值
     */
    public User getUser(String user, String password);

    /**
     *  将获取的新用户信息存储在数据库
     *  用于非学员账户注册
     * @param user 识别用户的唯一用户名
     * @param name 用户姓名
     * @param password 用户密码
     * @return  登录成功返回相应的用户类，登录失败返回空值
     */

    public int addUser(String user, String name, String password);

    /**
     *  将获取的新用户信息存储在数据库
     *  用于学员账户注册，需要有家长账户验证
     * @param user
     * @param name
     * @param password
     * @param guardianUser
     * @param guardianPassword
     * @return
     */
    public int addUserWithGuardian(String user, String name,String password, String guardianUser, String guardianPassword);

    /**
     *
     * @param guardian
     * @return
     */
    public ArrayList<User> getUsersWithGuardian(String guardian);
}
