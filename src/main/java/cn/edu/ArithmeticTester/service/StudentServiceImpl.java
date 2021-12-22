package cn.edu.ArithmeticTester.service;

import cn.edu.ArithmeticTester.dao.UserDao;
import cn.edu.ArithmeticTester.dao.StudentDaoImpl;
import cn.edu.ArithmeticTester.entity.User;

/**
 * @author prinzeugen
 */
public class StudentServiceImpl implements UserService {
    UserDao dao = new StudentDaoImpl();
    @Override
    public int registerWithGuardian(String user, String name, String password, String guardianUser, String guardianPassword) {
        return dao.addUserWithGuardian(user, name, password, guardianUser, guardianPassword);
    }

    @Override
    public int register(String user, String name, String password) {
        return 0;
    }

    @Override
    public User login(String user, String password) {
        return dao.getUser(user, password);
    }
}
