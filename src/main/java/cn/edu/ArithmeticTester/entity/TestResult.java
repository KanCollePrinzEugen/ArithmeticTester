package cn.edu.ArithmeticTester.entity;

/**
 * @author prinzeugen
 */
public class TestResult {
    /**
     * id: 练习记录的唯一ID
     * forumNum: 练习总题数
     * mistake: 练习错题数
     * accuracy: 练习正确率
     * studentName: 练习者账户名
     */
    int id;
    int forumNum;
    int mistake;
    double accuracy;
    String studentName;

    public TestResult(int id, int forumNum, int mistake, double accuracy, String studentName) {
        this.id = id;
        this.forumNum = forumNum;
        this.mistake = mistake;
        this.accuracy = accuracy;
        this.studentName = studentName;
    }

    public int getId() {
        return id;
    }

    public int getForumNum() {
        return forumNum;
    }

    public int getMistake() {
        return mistake;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public String getStudentName() {
        return studentName;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "id=" + id +
                ", forumNum=" + forumNum +
                ", mistake=" + mistake +
                ", accuracy=" + accuracy +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
