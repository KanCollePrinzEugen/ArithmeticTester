package cn.edu.ArithmeticTester.service;

import cn.edu.ArithmeticTester.dao.TestResultDao;
import cn.edu.ArithmeticTester.entity.TestResult;

import java.util.ArrayList;

/**
 * @author prinzeugen
 */
public class TestResultService {
    TestResultDao dao = new TestResultDao();
    public int addResult(int testId, int forumNum, int mistake, double accuracy, String studentUserName){
        return dao.addResult(testId, forumNum, mistake, accuracy, studentUserName);
    }

    public ArrayList<TestResult> getTestResultList(String studentUserName){
        return dao.getResult(studentUserName);
    }
}
