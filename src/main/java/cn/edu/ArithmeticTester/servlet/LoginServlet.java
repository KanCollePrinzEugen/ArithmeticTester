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

/**
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
        String sessionCacheKey = request.getParameter("sessionCacheKey");

        //提交的缓存为空则为重复提交
        if (sessionCacheKey != null) {
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
        Guardian guardian = null;
        switch (accountType) {
            case "监护人":
                guardian = (Guardian)guardianService.login(user, password);
                break;
            case "学员":
                student = (Student)studentService.login(user, password);
                break;
        }

        if (student != null) {
            HttpSession session = request.getSession();
            session.setAttribute("student", student);
            response.sendRedirect("studentHome.jsp");
        } else if (guardian != null){
            HttpSession session = request.getSession();
            session.setAttribute("guardian", guardian);
            response.sendRedirect("studentHome.jsp");
        } else{
            request.setAttribute("msg", "账号或密码错误");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
