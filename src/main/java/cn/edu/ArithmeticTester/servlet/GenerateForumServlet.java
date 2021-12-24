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
 * 处理用户提交的新测试请求
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
        //存储用户指定的运算类型
        StringBuilder optionsString = new StringBuilder();

        //处理用户输入非法值（用户输入空值）
        if (req.getParameter("generateNum") == null || req.getParameter("generateNum") == ""){
            //存放request作用域
            req.setAttribute("msg", "请输入正确的值");
            //请求转发
            req.getRequestDispatcher("/newTest.jsp").forward(req, resp);
            return;
        }

        //获取用户指定的算式数和运算法则
        String[] options = req.getParameterValues("rules");
        int generateNum = Integer.parseInt(req.getParameter("generateNum"));

        //处理用户输入非法值（用户输入小于零的算式数）
        if (generateNum <= 0){
            //存放request作用域
            req.setAttribute("msg", "请输入正确的值");
            //请求转发
            req.getRequestDispatcher("/newTest.jsp").forward(req, resp);
            return;
        }

        //处理用户输入非法值（用户没有选择任何运算法则）
        if (options == null){
            //存放request作用域
            req.setAttribute("msg", "请选择正确的选项");
            //请求转发
            req.getRequestDispatcher("/newTest.jsp").forward(req, resp);
            return;
        }

//        System.out.println("num:" + generateNum);
        for (String option : options) {
//            System.out.println("option:" + option);
            switch (option){
                //用户选择加法（Forum类中option值为1表示加法）
                case "add":
                    optionsString.append("1");
                    break;
                //用户选择减法（Forum类中option值为2表示减法）
                case "sub":
                    optionsString.append("2");
                    break;
                //用户选择乘法（Forum类中option值为3表示乘法）
                case "mul":
                    optionsString.append("3");
                    break;
                //用户选择除法（Forum类中option值为4表示除法）
                case "div":
                    optionsString.append("4");
                    break;
            }
        }

        //从service获取生产的算式
        List<Forum> forums = service.generateForums(generateNum, (optionsString).toString());
        if (forums == null) {
            req.setAttribute("msg", "发生了错误");
            req.getRequestDispatcher("/newTest.jsp").forward(req, resp);
        } else {
            //生产成功，设置相应的Attribute并且跳转到测试页面
            HttpSession session = req.getSession();
            //生产的算式
            session.setAttribute("forums", forums);
//            session.setAttribute("generateNum",generateNum);
            //生产的算式数量
            System.out.println("generateNum:"+generateNum);
            //将生产的算式数量转发到其他servlet（AnswerProcess）
            this.getServletContext().setAttribute("generateNum",generateNum);
            resp.sendRedirect("testPage.jsp");
        }
    }
}
