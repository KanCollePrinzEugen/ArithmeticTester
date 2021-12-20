package cn.edu.ArithmeticTester.service;

import cn.edu.ArithmeticTester.entity.User;

/**
 * 用于全体用户的service接口
 * @author prinzeugen
 */
public interface UserService {
    /**
     * 注册新用户的service
     * @param user 识别用户的唯一用户名
     * @param name  用户姓名
     * @param password  用户密码
     * @return  注册成功返回true，注册失败返回false
     */
    public boolean register(String user, String name, String password);

    /**
     * 用户登录的service
     * @param user 识别用户的唯一用户名
     * @param name 用户姓名
     * @param password 用户密码
     * @return  登录成功返回相应的用户类，登录失败返回空值
     */
    public User login(String user, String name, String password);
}
