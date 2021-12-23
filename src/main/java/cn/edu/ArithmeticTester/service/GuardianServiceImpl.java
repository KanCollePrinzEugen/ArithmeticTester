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
