<%@ page import="cn.edu.ArithmeticTester.entity.Forum" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: prinz
  Date: 2021/12/23
  Time: 1:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新的测试</title>
    <link rel="stylesheet" href="css/newTest.css">
    <link rel="stylesheet" href="css/button.css">
</head>
<body style="background: url('img/XmasBeachHuts_ZH-CN6195800613_1920x1080.jpg')">

    <div class="content">
        <%
            String msg = (String)request.getAttribute("msg");
            if(msg != null){
        %>
        <script type="text/javascript"> alert("<%=msg%>");</script>
        <%
            }
        %>
        <a href="studentHome.jsp" class="back">我不卷了，我不卷了……</a>
        <form method="post" action="GenerateForumServlet">
            <div class = "textBox">
                <p>
                    <label>
                        请输入生成的题目数量：
                        <input type="text" name="generateNum" class="textInput">
                    </label>
                </p>
            </div>
            <div class="checkBox">
                <label>
                    <input type="checkbox" value="add" name="rules" checked="checked">
                    加法
                </label>
                <label>
                    <input type="checkbox" value="sub" name="rules" checked="checked">
                    减法
                </label>
                <label>
                    <input type="checkbox" value="mul" name="rules" checked="checked">
                    乘法
                </label>
                <label>
                    <input type="checkbox" value="div" name="rules" checked="checked">
                    除法
                </label>
            </div>
            <input type="submit" value="开卷!" class="submitButton">
        </form>
    </div>
</body>
</html>
