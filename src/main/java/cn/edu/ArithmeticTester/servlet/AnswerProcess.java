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
 * @author prinzeugen
 */
public class AnswerProcess extends HttpServlet {
    int id = 1;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TestResultService service = new TestResultService();
        String studentName = (String) this.getServletContext().getAttribute("studentName");
        String studentUserName = (String) this.getServletContext().getAttribute("studentUserName");
        int value;
        /*
          正确题数
          错误题数
          总题数
          正确率
         */
        int right=0;
        int mistake=0;
        int generateNum = (int) this.getServletContext().getAttribute("generateNum");
        int[] answerInput = new int[generateNum];
        double accuracy = 0;
        List<Forum> forms = (List<Forum>)req.getSession().getAttribute("forums");
        for (Forum form : forms) {
            System.out.println(form.getResult());
        }
        for (int i=1; i <= generateNum; i++){
            int rightAnswer = forms.get(i-1).getResult();
            if (req.getParameter("answerInput"+ i) == null || req.getParameter("answerInput"+ i) == ""){
                //存放request作用域
                req.setAttribute("msg", "答案不能留空");
                //请求转发
                req.getRequestDispatcher("/testPage.jsp").forward(req, resp);
                return;
            }
            value = Integer.parseInt(req.getParameter("answerInput"+ i));
            answerInput[i-1] = value;
            System.out.println(value);
            System.out.println(rightAnswer);
            if (value == rightAnswer){
                accuracy += 1.0/(double)generateNum;
                right++;
            } else{
                mistake++;
            }
        }
        System.out.println(accuracy);

        HttpSession session = req.getSession();
        service.addResult(id, generateNum, mistake, accuracy, studentUserName);
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
