<%@ page import="cn.edu.ArithmeticTester.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: prinz
  Date: 2021/12/22
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>学生主页</title>
</head>
<body>
<%
    Student student = (Student)session.getAttribute("student");
    String studentName = student.getName();
%>
    <h1>欢迎您！<%= studentName%></h1>
    <div class="content">
        <button>
            <a href="newTest.jsp">开始新测试</a>
        </button>
    </div>
</body>
</html>