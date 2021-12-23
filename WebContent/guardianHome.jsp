<%@ page import="cn.edu.ArithmeticTester.entity.Student" %>
<%@ page import="cn.edu.ArithmeticTester.entity.Guardian" %>
<%@ page import="cn.edu.ArithmeticTester.entity.User" %>
<%@ page import="java.util.ArrayList" %><%--
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
    <link rel="stylesheet" href="css/guardianHome.css">
    <link rel="stylesheet" href="css/button.css">
</head>
<body>
<%
    Guardian guardian = (Guardian)session.getAttribute("guardian");
    ArrayList<User> studentWithGuardian= (ArrayList<User>)session.getAttribute("studentWithGuardian");
    String guardianName = guardian.getName();
%>
    <div class="content">
        <h1>欢迎您！<%= guardianName%></h1>
        <button class="submitButton">
            <a onclick="location.href='LogoutServlet'" style="text-decoration:none; color:white ;">退出登录</a>
        </button>
        <div class="yourChildren">
            <h2>您的孩子</h2>
            <%
                if (studentWithGuardian == null){
            %>
                <p>您还没有已连接的孩子账号</p>
            <%
                } else {
                  for (User student : studentWithGuardian){
            %>
                <div class="stuContent">
                    <p style="float:left">
                        <%=student.getName() %>
                    </p>
                    <button class="submitButton">
                        <a onclick="location.href='RecentTestResult?studentUserName=<%=student.getUsername()%>&studentName=<%=student.getName()%>'"
                           style="text-decoration:none; color:white ;">查看近期成绩</a>
                    </button>
                    <div/>
            <%
                  }
                }
            %></div>
        </div>
    </div>
</body>
</html>
