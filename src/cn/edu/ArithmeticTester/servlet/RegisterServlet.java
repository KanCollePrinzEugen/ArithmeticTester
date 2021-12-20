package cn.edu.ArithmeticTester.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author prinzeugen
 */
@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String user = request.getParameter("user");
        String name = request.getParameter("name");
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
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        //验证码输入错误
        if (! sessionCacheKey.equalsIgnoreCase(verifyCode)){
            //存放request作用域
            request.setAttribute("msg", "验证码输入错误");
            //请求转发
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }
    }
}
