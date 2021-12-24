package cn.edu.ArithmeticTester.service;

import cn.edu.ArithmeticTester.dao.TestResultDao;
import cn.edu.ArithmeticTester.entity.TestResult;

import java.util.ArrayList;

/**
 * 用于练习结果类的service
 * @author prinzeugen
 */
public class TestResultService {
    TestResultDao dao = new TestResultDao();

    /**
     * 用于添加练习结果
     * @param forumNum 练习总题数
     * @param mistake   错题数
     * @param accuracy  正确率
     * @param studentUserName   练习者用户名
     * @return  添加成功返回大于0的值，添加失败返回0或负值
     */
    public int addResult(int forumNum, int mistake, double accuracy, String studentUserName){
        return dao.addResult(forumNum, mistake, accuracy, studentUserName);
    }

    /**
     * 用于获取指定学生的所有练习结果
     * @param studentUserName 学生类用户名
     * @return  查询成功返回包装好的结果ArrayList，否则返回null
     */
    public ArrayList<TestResult> getTestResultList(String studentUserName){
        return dao.getResult(studentUserName);
    }
}
