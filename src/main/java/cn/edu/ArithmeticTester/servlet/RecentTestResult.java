package cn.edu.ArithmeticTester.servlet;

import cn.edu.ArithmeticTester.entity.Student;
import cn.edu.ArithmeticTester.entity.TestResult;
import cn.edu.ArithmeticTester.entity.User;
import cn.edu.ArithmeticTester.service.TestResultService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 处理显示指定学生账户的所有练习记录的请求
 * @author prinzeugen
 */
public class RecentTestResult extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        TestResultService service = new TestResultService();
        //获取指定学生账户的用户名和姓名
        String studentUserName = req.getParameter("studentUserName");
        String studentName = req.getParameter("studentName");
        ArrayList<TestResult> testResults = service.getTestResultList(studentUserName);

//        System.out.println("studentUserName:"+studentUserName);
//        System.out.println("studentName:"+studentName);

        //若学生没有练习记录
        if(testResults.get(0) == null){
            session.setAttribute("testResults", null);
            resp.sendRedirect("testResultOfStudent.jsp");
        }

        //将练习记录传送到testResultOfStudent.jsp
        session.setAttribute("testResults", testResults);
        session.setAttribute("studentName", studentName);
        resp.sendRedirect("testResultOfStudent.jsp");
    }
}
