package cn.edu.ArithmeticTester.service;

import cn.edu.ArithmeticTester.dao.UserDao;
import cn.edu.ArithmeticTester.dao.StudentDaoImpl;
import cn.edu.ArithmeticTester.entity.User;

import java.util.ArrayList;

/**
 * @author prinzeugen
 */
public class StudentServiceImpl implements UserService {
    UserDao dao = new StudentDaoImpl();
    @Override
    public int registerWithGuardian(String user, String name, String password, String guardianUser, String guardianPassword) {
        return dao.addUserWithGuardian(user, name, password, guardianUser, guardianPassword);
    }

    /**
     * 仅用于家长账户注册，学生service不使用
     * @param user 识别用户的唯一用户名
     * @param name  用户姓名
     * @param password  用户密码
     * @return 0
     */
    @Override
    public int register(String user, String name, String password) {
        return 0;
    }

    @Override
    public User login(String user, String password) {
        return dao.getUser(user, password);
    }

    /**
     * 仅用于家长账户，学生service不使用
     * @param guardianUser 家长账户名
     * @return null
     */
    @Override
    public ArrayList<User> getStudentWithGuardian(String guardianUser) {
        return null;
    }
}
