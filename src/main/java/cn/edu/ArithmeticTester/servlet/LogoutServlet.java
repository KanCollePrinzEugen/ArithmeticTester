package cn.edu.ArithmeticTester.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理账户退出登录
 * @author prinzeugen
 */
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //清除session并且回到登录页面
        req.getSession().invalidate();
        resp.sendRedirect("index.jsp");
    }
}
