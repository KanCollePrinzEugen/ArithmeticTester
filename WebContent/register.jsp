<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎使用算术练习系统-注册新账号</title>
    <link rel="stylesheet" href="css/register.css">
    <link rel="stylesheet" href="css/button.css">
    <script type="text/javascript" src="script/register.js"></script>
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
        <a href="index.jsp" class="back">返回</a>
        <h1>新用户注册</h1>
        <form action="RegisterServlet" method="post">
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
                        <p>姓名：</p>
                    </td>
                    <td>
                        <label>
                            <input class="textInput" type="text" name="name">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>密码：</p>
                    </td>
                    <td>
                        <label>
                            <input class="textInput" type="password" name="pwd">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>密码确认：</p>
                    </td>
                    <td>
                        <label>
                            <input class="textInput" type="password" name="pwdConf">
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
                        <input class="submitButton" type="submit" value="注册">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>