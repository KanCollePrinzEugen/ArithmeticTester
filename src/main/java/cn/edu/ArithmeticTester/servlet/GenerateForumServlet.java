package cn.edu.ArithmeticTester.servlet;

import cn.edu.ArithmeticTester.entity.Forum;
import cn.edu.ArithmeticTester.service.ComputeService;
import cn.edu.ArithmeticTester.utils.GenerateTool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        String[] options = req.getParameterValues("rules");
        int generateNum = Integer.parseInt(req.getParameter("generateNum"));

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

        service.generateForums(generateNum, (optionsString).toString());
    }
}
