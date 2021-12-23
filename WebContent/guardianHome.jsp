<%@ page import="cn.edu.ArithmeticTester.entity.Student" %>
<%@ page import="cn.edu.ArithmeticTester.entity.Guardian" %><%--
  Created by IntelliJ IDEA.
  User: prinz
  Date: 2021/12/22
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>家长主页</title>
</head>
<body>
<%
    Guardian guardian = (Guardian)session.getAttribute("guardian");
    String guardianName = guardian.getName();
%>
<h1>欢迎您！<%= guardianName%></h1>
</body>
</html>
