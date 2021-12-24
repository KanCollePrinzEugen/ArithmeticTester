package cn.edu.ArithmeticTester.servlet;

import cn.edu.ArithmeticTester.entity.Forum;
import cn.edu.ArithmeticTester.service.TestResultService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 处理用户提交的测试结果
 * @author prinzeugen
 */
public class AnswerProcess extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TestResultService service = new TestResultService();
        //获取答题的学生账户名和姓名
        String studentName = (String) this.getServletContext().getAttribute("studentName");
        String studentUserName = (String) this.getServletContext().getAttribute("studentUserName");
        //存储用户提交的答案
        int value;
        /*
          right 正确题数
          mistake 错误题数
          generateNum 总题数
          answerInput 输入的答案数
          accuracy 正确率
         */
        int right=0;
        int mistake=0;
        //接受从其他servlet（GenerateForumServlet）传送的总题数
        int generateNum = (int) this.getServletContext().getAttribute("generateNum");
        int[] answerInput = new int[generateNum];
        double accuracy = 0;
        //获取测试生产的算式
        List<Forum> forms = (List<Forum>)req.getSession().getAttribute("forums");
//        for (Forum form : forms) {
//            System.out.println(form.getResult());
//        }
        for (int i=1; i <= generateNum; i++){
            int rightAnswer = forms.get(i-1).getResult();
            //如果答案留空则返回测试页面
            if (req.getParameter("answerInput"+ i) == null || req.getParameter("answerInput"+ i) == ""){
                //存放request作用域
                req.setAttribute("msg", "答案不能留空");
                //请求转发
                req.getRequestDispatcher("/testPage.jsp").forward(req, resp);
                return;
            }
            //获取用户提交的答案·
            value = Integer.parseInt(req.getParameter("answerInput"+ i));
            answerInput[i-1] = value;
//            System.out.println(value);
//            System.out.println(rightAnswer);
            //如果答案正确，增加相应的正确题数和正确率
            if (value == rightAnswer){
                accuracy += 1.0/(double)generateNum;
                right++;
            } else{
                //答案错误增加错误题数
                mistake++;
            }
        }
//        System.out.println(accuracy);

        HttpSession session = req.getSession();
        //将测试结果储存进数据库
        service.addResult(generateNum, mistake, accuracy, studentUserName);
        //设置用于显示结果的Attribute
        session.setAttribute("accuracy", accuracy);
        session.setAttribute("forms", forms);
        session.setAttribute("answerInput", answerInput);
        session.setAttribute("studentName", studentName);
        session.setAttribute("generateNum", generateNum);
        session.setAttribute("right", right);
        session.setAttribute("mistake", mistake);

        resp.sendRedirect("testResult.jsp");
    }
}
