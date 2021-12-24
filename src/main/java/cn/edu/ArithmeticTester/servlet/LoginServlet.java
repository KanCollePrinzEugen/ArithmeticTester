package cn.edu.ArithmeticTester.servlet;

import cn.edu.ArithmeticTester.entity.Guardian;
import cn.edu.ArithmeticTester.entity.Student;
import cn.edu.ArithmeticTester.entity.User;
import cn.edu.ArithmeticTester.service.GuardianServiceImpl;
import cn.edu.ArithmeticTester.service.StudentServiceImpl;
import cn.edu.ArithmeticTester.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 处理账户登录的servlet
 * @author prinzeugen
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService studentService = new StudentServiceImpl();
        UserService guardianService = new GuardianServiceImpl();
        request.setCharacterEncoding("utf-8");

        String user = request.getParameter("user");
        String password = request.getParameter("pwd");
        String passwordConf = request.getParameter("pwdConf");
        String verifyCode = request.getParameter("verifyCode");
        String accountType = request.getParameter("account");
        String sessionCacheKey = (String) request.getSession().getAttribute("sessionCacheKey");

        //提交的缓存为空则为重复提交
        if (sessionCacheKey == null) {
            //存放request作用域
            request.setAttribute("msg", "请勿重复提交");
            //请求转发
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }

        //验证码输入错误
        if (!sessionCacheKey.equalsIgnoreCase(verifyCode)) {
            //存放request作用域
            request.setAttribute("msg", "验证码输入错误");
            //请求转发
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }

        //检查账户类型并验证账户信息
        Student student = null;
        ArrayList<User> studentWithGuardian = new ArrayList<>();
        Guardian guardian = null;
        switch (accountType) {
            //选择的是家长账户，将登录信息传送给家长的service
            case "guardian":
                guardian = (Guardian)guardianService.login(user, password);
                studentWithGuardian = guardianService.getStudentWithGuardian(user);
                break;
            //选择的是学生账户，将登录信息传送给学生的service
            case "student":
                student = (Student)studentService.login(user, password);
                break;
        }

        //学生账户登录成功，跳转到学生主页
        if (student != null) {
            HttpSession session = request.getSession();
            //传送学生账户信息
            session.setAttribute("student", student);
            this.getServletContext().setAttribute("studentName", student.getName());
            this.getServletContext().setAttribute("studentUserName", student.getUsername());
            response.sendRedirect("studentHome.jsp");
        //家长账户登录成功，跳转到家长主页
        } else if (guardian != null){
            HttpSession session = request.getSession();
            //传送家长账户信息
            session.setAttribute("guardian", guardian);
            session.setAttribute("studentWithGuardian", studentWithGuardian);
            response.sendRedirect("guardianHome.jsp");
            //否则登录失败，传送信息并且回到登录页面
        } else{
            request.setAttribute("msg", "账号或密码错误");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
