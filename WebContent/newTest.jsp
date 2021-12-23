<%--
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
</head>
<body>
    <div class="content">
        <form method="post" action="GenerateForumServlet">
            <div class="topBox">
                <p>
                    请输入生成的题目数量：
                    <input type="text" name="generateNum">
                </p>
                <input type="checkbox" value="add" name="rules">加法
                <input type="checkbox" value="sub" name="rules">减法
                <input type="checkbox" value="mul" name="rules">乘法
                <input type="checkbox" value="div" name="rules">除法
                <input type="submit" value="生成">
            </div>
        </form>
    </div>
</body>
</html>
