<%@ page import="cn.edu.ArithmeticTester.entity.Student" %>
<%@ page import="cn.edu.ArithmeticTester.entity.Forum" %>
<%@ page import="java.util.List" %><%--
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
%>
  <div class="content">
      <h1><%=studentName%>的测试结果</h1>
      <p>总题数：<%=generateNum%></p>
      <p>答对：<%=right%></p>
      <p>答错：<%=mistake%></p>
      <p>正确率：<%=accuracy*100%>%</p>
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
                          if (result == answerInput[i]){
                              document.write('<svg t="1640263664051" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2033" width="50" height="50"><path d="M219.952 512.576l210.432 210.432-45.248 45.256-210.432-210.432z" p-id="2034"></path><path d="M799.672 262.264l45.256 45.256-460.464 460.464-45.256-45.256z" p-id="2035"></path></svg>')
                          } else {
                              document.write('<svg t="1640264046247" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2833" width="50" height="50"><path d="M806.4 263.2l-45.6-45.6L512 467.2 263.2 217.6l-45.6 45.6L467.2 512 217.6 760.8l45.6 45.6L512 557.6l248.8 248.8 45.6-45.6L557.6 512z" p-id="2834"></path></svg>')
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
