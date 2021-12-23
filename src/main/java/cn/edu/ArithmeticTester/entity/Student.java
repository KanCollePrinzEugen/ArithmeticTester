package cn.edu.ArithmeticTester.entity;

/**
 * 学生类
 * @author prinz
 */
public class Student extends User{
    String guardian;

    public Student(String username, String name, int password, String guardian) {
        super(username, name, password);
        this. guardian = guardian;
    }

    public String getGuardian() {
        return guardian;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
