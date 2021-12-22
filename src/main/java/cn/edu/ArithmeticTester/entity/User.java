package cn.edu.ArithmeticTester.entity;

/**
 * @author prinzeugen
 */
public abstract class User {
    private String username;
    private String name;
    private int password;

    public User(String username, String name, int password) {
        this.username = username;
        this.name = name;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public int getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
