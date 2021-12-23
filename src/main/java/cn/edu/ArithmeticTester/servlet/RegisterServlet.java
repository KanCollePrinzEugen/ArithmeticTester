package cn.edu.ArithmeticTester.servlet;

import cn.edu.ArithmeticTester.entity.Guardian;
import cn.edu.ArithmeticTester.entity.Student;
import cn.edu.ArithmeticTester.service.GuardianServiceImpl;
import cn.edu.ArithmeticTester.service.StudentServiceImpl;
import cn.edu.ArithmeticTester.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author prinzeugen
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService studentService = new StudentServiceImpl();
        UserService guardianService = new GuardianServiceImpl();
        req.setCharacterEncoding("utf-8");

        String user = req.getParameter("user");
        String guardianUser = req.getParameter("guardianUser");
        String name = req.getParameter("name");
        String password = req.getParameter("pwd");
        String guardianPassword = req.getParameter("guardianPassword");
        String accountType = req.getParameter("account");
        String verifyCode = req.getParameter("verifyCode");
        String sessionCacheKey = (String) req.getSession().getAttribute("sessionCacheKey");
        System.out.println(sessionCacheKey);
        //提交的缓存为空则为重复提交
        if (sessionCacheKey == null) {
            //存放request作用域
            req.setAttribute("msg", "请勿重复提交");
            //请求转发
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }
        System.out.println("sessionCacheKey:"+sessionCacheKey);
        //验证码输入错误
        if (!sessionCacheKey.equalsIgnoreCase(verifyCode)) {
            //存放request作用域
            req.setAttribute("msg", "验证码输入错误");
            //请求转发
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }
        System.out.println("accountType:" + accountType);
        int result;
        if ("student".equals(accountType)){
            result = studentService.registerWithGuardian(user,name ,password, guardianUser, guardianPassword);
        } else {
            result = guardianService.register(user,name ,password);
        }

        if(result > 0){
            //注册成功，返回首页
            resp.sendRedirect("index.jsp");
        } else {
            //注册失败，刷新页面
            resp.sendRedirect("register.jsp");
        }
    }
}