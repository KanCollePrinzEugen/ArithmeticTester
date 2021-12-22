<%@ page import="cn.edu.ArithmeticTester.entity.Student" %>
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
</body>
</html>