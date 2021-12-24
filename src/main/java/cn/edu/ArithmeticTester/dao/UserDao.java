package cn.edu.ArithmeticTester.dao;

import cn.edu.ArithmeticTester.entity.User;

import java.util.ArrayList;

/**
 * 定义用户Dao接口
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
     *  仅用于家长账户注册
     * @param user 识别用户的唯一用户名
     * @param name 用户姓名（可以重名）
     * @param password 用户密码
     * @return  注册成功返回大于0的值，登录失败返回0
     */

    public int addUser(String user, String name, String password);

    /**
     *  将获取的新用户信息存储在数据库，仅用于学生账户
     *  用于学员账户注册，需要和家长账户连接
     * @param user  识别学员用户的唯一用户名
     * @param name  学员姓名（可以重名）
     * @param password  学员用户密码
     * @param guardianUser  用于验证家长账户的家长用户名
     * @param guardianPassword  对应的家长用户密码
     * @return 注册成功返回大于0的值，登录失败返回0
     */
    public int addUserWithGuardian(String user, String name,String password, String guardianUser, String guardianPassword);

    /**
     *  用于获取家长账户连接的所有孩子账户，仅用于家长账户
     * @param guardian 家长用户名
     * @return  与该家长账户连接的所有孩子账户
     */
    public ArrayList<User> getUsersWithGuardian(String guardian);
}
