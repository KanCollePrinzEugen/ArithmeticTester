<%@ page import="cn.edu.ArithmeticTester.entity.Student" %>
<%@ page import="cn.edu.ArithmeticTester.entity.Forum" %>
<%@ page import="java.util.List" %>
<%@ page import="java.math.BigDecimal" %><%--
  Created by IntelliJ IDEA.
  User: prinzeugen
  Date: 2021/12/23
  Time: 5:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试结果</title>
    <link rel="stylesheet" href="css/testResult.css">
    <link rel="stylesheet" href="css/button.css">
    <script src="script/forumsDisplay.js"></script>
</head>
<body>
<%
    int[] answerInput = (int[]) session.getAttribute("answerInput");
    String studentName = (String) session.getAttribute("studentName");
    double accuracy = (Double)session.getAttribute("accuracy");
    Integer generateNum = (Integer)session.getAttribute("generateNum");
    Integer right = (Integer)session.getAttribute("right");
    Integer mistake = (Integer)session.getAttribute("mistake");
    List<Forum> forms = (List<Forum>)session.getAttribute("forms");
    BigDecimal bigDecimal = new BigDecimal(accuracy*100);
    bigDecimal = bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);
%>
  <div class="content">
      <h1><%=studentName%>的测试结果</h1>
      <p>总题数：<%=generateNum%></p>
      <p>答对：<%=right%></p>
      <p>答错：<%=mistake%></p>
      <p>正确率：<%=bigDecimal%>%</p>
      <button class="submitButton">
          <a href="newTest.jsp" style="text-decoration:none; color:white ;">开始新测试</a>
      </button>
      <button class="submitButton">
          <a href="studentHome.jsp" style="text-decoration:none; color:white ;">回到主页</a>
      </button>
      <table>
          <%
              int i=0;
              //从servlet获取算式
              for (Forum form : forms) {
          %>
          <script>
              var num1 = "<%=form.getNum1()%>";
              var num2 = "<%=form.getNum2()%>";
              var option = "<%=form.getOption()%>";
              var result = "<%=form.getResult()%>";
              <%--answerArr.push("<%=form.getResult()%>")--%>
              // var result = ;
              var forum = displayForum(num1, num2, option);
          </script>
          <tr>
              <td>
                  <script>
                      document.write(forum);
                  </script>
              </td>
              <td>
                  <script>
                      document.write(result);
                  </script>
              </td>
              <td style="width: 115px">
                  <p>
                      你的答案：<%=answerInput[i]%>
                  </p>
              </td>
              <td>
                  <p>
                      <script>
                          if (result == <%=answerInput[i]%>){
                              document.write('✔')
                          } else {
                              document.write('✘')
                          }
                      </script>
                  </p>
              </td>
          </tr>
          <%
                  i++;
              }
          %>
      </table>
  </div>
</body>
</html>
