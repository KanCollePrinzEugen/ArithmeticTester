package cn.edu.ArithmeticTester.servlet;

import cn.edu.ArithmeticTester.entity.Forum;
import cn.edu.ArithmeticTester.service.ComputeService;
import cn.edu.ArithmeticTester.utils.GenerateTool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author prinz
 */
public class GenerateForumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ComputeService service = new ComputeService();
        req.setCharacterEncoding("utf-8");
        StringBuilder optionsString = new StringBuilder();

        if (req.getParameter("generateNum") == null || req.getParameter("generateNum") == ""){
            //存放request作用域
            req.setAttribute("msg", "请输入正确的值");
            //请求转发
            req.getRequestDispatcher("/newTest.jsp").forward(req, resp);
            return;
        }

        String[] options = req.getParameterValues("rules");
        int generateNum = Integer.parseInt(req.getParameter("generateNum"));

        if (generateNum <= 0){
            //存放request作用域
            req.setAttribute("msg", "请输入正确的值");
            //请求转发
            req.getRequestDispatcher("/newTest.jsp").forward(req, resp);
            return;
        }

        if (options == null){
            //存放request作用域
            req.setAttribute("msg", "请选择正确的选项");
            //请求转发
            req.getRequestDispatcher("/newTest.jsp").forward(req, resp);
            return;
        }

        System.out.println("num:" + generateNum);
        for (String option : options) {
            System.out.println("option:" + option);
            switch (option){
                case "add":
                    optionsString.append("1");
                    break;
                case "sub":
                    optionsString.append("2");
                    break;
                case "mul":
                    optionsString.append("3");
                    break;
                case "div":
                    optionsString.append("4");
                    break;
            }
        }

        List<Forum> forums = service.generateForums(generateNum, (optionsString).toString());
        if (forums == null) {
            req.setAttribute("msg", "发生了错误");
            req.getRequestDispatcher("/newTest.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("forums", forums);
//            session.setAttribute("generateNum",generateNum);
            System.out.println("generateNum:"+generateNum);
            this.getServletContext().setAttribute("generateNum",generateNum);
            resp.sendRedirect("testPage.jsp");
        }
    }
}
