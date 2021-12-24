package cn.edu.ArithmeticTester.entity;

/**
 * @author prinzeugen
 */
public abstract class User {
    /**
     * username: 用户唯一用户名
     * name: 用户姓名
     * password: 用户账户密码
     */
    private String username;
    private String name;
    private String password;

    public User(String username, String name, String password) {
        this.username = username;
        this.name = name;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
