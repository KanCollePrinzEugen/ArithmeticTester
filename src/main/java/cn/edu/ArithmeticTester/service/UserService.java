package cn.edu.ArithmeticTester.service;

import cn.edu.ArithmeticTester.entity.User;

/**
 * 用于全体用户的service接口
 * @author prinzeugen
 */
public interface UserService {
    /**
     * 注册新学员用户的service
     * @param user 识别用户的唯一用户名
     * @param name  用户姓名
     * @param password  用户密码
     * @param guardianUser 监护人账户
     * @param guardianPassword 监护人密码
     * @return  注册成功返回1，注册失败返回0
     */
    public int registerWithGuardian(String user, String name, String password, String guardianUser, String guardianPassword);

    /**
     * 注册普通用户的service
     * @param user 识别用户的唯一用户名
     * @param name  用户姓名
     * @param password  用户密码
     * @return 注册成功返回1，注册失败返回0
     */
    public int register(String user, String name, String password);

    /**
     * 用户登录的service
     * @param user 识别用户的唯一用户名
     * @param password 用户密码
     * @return  登录成功返回相应的用户类，登录失败返回空值
     */
    public User login(String user, String password);
}
