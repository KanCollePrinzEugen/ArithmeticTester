<%@ page import="cn.edu.ArithmeticTester.entity.Forum" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: prinzeugen
  Date: 2021/12/23
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>正在进行一次测试</title>
    <link rel="script" href="script/forumsDisplay.js">
    <link rel="stylesheet" href="css/testPage.css">
    <link rel="stylesheet" href="css/button.css">
    <script src="script/forumsDisplay.js"></script>
</head>
<body style="background: url('img/XmasBeachHuts_ZH-CN6195800613_1920x1080.jpg')">
  <%
    String msg = (String)request.getAttribute("msg");
    if(msg != null){
  %>
  <script type="text/javascript"> alert("<%=msg%>");</script>
  <%
    }
  %>
  <div class="content">
    <form method="post" name="testForm" id="testForm" action="AnswerProcess">
      <div class="forumsBox">
        <%
          //从servlet获取算式
          List<Forum> forms = (List<Forum>)request.getSession().getAttribute("forums");

          for (Forum form : forms) {
        %>
        <script>
          count = count + 1;
          var num1 = "<%=form.getNum1()%>";
          var num2 = "<%=form.getNum2()%>";
          var option = "<%=form.getOption()%>";
          answerArr.push("<%=form.getResult()%>")
          // var result = ;
          //将生产算式以平常的运算符号显示
          var forum = displayForum(num1, num2, option);
        </script>
        <div class="forum">
          <table>
            <tr>
              <td>
                <script>
                  document.write(count)
                </script>
              </td>
              <td>
                <script>
                  document.write(forum);
                </script>
              </td>
              <td>
                <input type="text" name="answerInput" class="answerText" id="answerInput">
                <script>
                  var answerInput = document.getElementById("answerInput")
                  answerInput.setAttribute("id", "answerInput" + (count))
                  answerInput.setAttribute("name", "answerInput" + (count))
                </script>
              </td>
            </tr>
          </table>
        </div>
        <%
          }
        %>
      </div>
      <input type="submit" value="提交答案" class="submitButton" style="text-align: center">
      <button class="submitButton">
        <a href="studentHome.jsp" style="text-decoration:none; color:white ;">退出测试</a>
      </button>
    </form>
  </div>
</body>
</html>
