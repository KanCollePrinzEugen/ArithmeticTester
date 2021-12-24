package cn.edu.ArithmeticTester.service;

import cn.edu.ArithmeticTester.dao.GuardianDaoImpl;
import cn.edu.ArithmeticTester.dao.UserDao;
import cn.edu.ArithmeticTester.entity.User;

import java.util.ArrayList;

/**
 * @author prinzeugen
 */
public class GuardianServiceImpl implements UserService{
    UserDao dao = new GuardianDaoImpl();

    /**
     * 仅用于学生账户注册，家长service不使用
     * @param user 识别用户的唯一用户名
     * @param name  用户姓名
     * @param password  用户密码
     * @param guardianUser 监护人账户
     * @param guardianPassword 监护人密码
     * @return 0
     */
    @Override
    public int registerWithGuardian(String user, String name, String password, String guardianUser, String guardianPassword) {
        return 0;
    }

    @Override
    public int register(String user, String name, String password) {
        return dao.addUser(user, name, password);
    }

    @Override
    public User login(String user, String password) {
        return dao.getUser(user, password);
    }

    @Override
    public ArrayList<User> getStudentWithGuardian(String guardianUser) {
        return dao.getUsersWithGuardian(guardianUser);
    }
}
