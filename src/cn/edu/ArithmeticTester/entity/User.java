package cn.edu.ArithmeticTester.entity;

/**
 * @author prinzeugen
 */
public abstract class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
