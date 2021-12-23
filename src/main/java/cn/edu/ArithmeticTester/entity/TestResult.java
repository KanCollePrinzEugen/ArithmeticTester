package cn.edu.ArithmeticTester.entity;

/**
 * @author prinzeugen
 */
public class TestResult {
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
