<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
  <meta charset="UTF-8">
  <title>欢迎使用算术练习系统-请登录</title>
  <link rel="stylesheet" href="css/index.css">
  <link rel="stylesheet" href="css/button.css">
</head>
<body>
<div class="content">
    <%
        String msg = (String)request.getAttribute("msg");
        if(msg != null){
    %>
    <script type="text/javascript"> alert("<%=msg%>");</script>
    <%
        }
    %>
  <h1>欢迎使用算术练习系统</h1>
    <form method="post" action="LoginServlet">
        <table>
            <tr>
                <td>
                    <p>账号：</p>
                </td>
                <td>
                    <label>
                        <input class="textInput" type="text" name="user">
                    </label>
                </td>
            </tr>
            <tr>
                <td>
                    <p>密码：</p>
                </td>
                <td>
                    <label>
                        <input class="textInput" type="text" name="pwd">
                    </label>
                </td>
            </tr>
            <tr>
                <td>
                    <p>账户类型：</p>
                </td>
                <td>
                    <label>
                        <select class="accountSelector" name="account" id="accountSelector">
                            <option value="guardian">监护人</option>
                            <option value="student">学员</option>
                        </select>
                    </label>
                </td>
            </tr>
            <tr>
                <td>
                    <p>验证码：</p>
                </td>
                <td>
                    <label>
                        <input class="verifyCodeInput" type="text" name="verifyCode"/>
                        <img src="VerifyCodeServlet" class="verifyCode" alt="verifyCode"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input class="submitButton" type="submit" value="登录">
                </td>
            </tr>
        </table>
    </form>
  <a href="register.jsp">新用户注册</a>
</div>
</body>
</html>