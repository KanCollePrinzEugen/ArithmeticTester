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
        <a href="index.html" class="back">返回</a>
        <h1>新用户注册</h1>
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
                    <p>账户类型：</p>
                </td>
                <td>
                    <label>
                        <select class="accountSelector" name="account">
                            <option value="guardian">监护人</option>
                            <option value="student">学员</option>
                            <option value="admin">管理员</option>
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
                        <img src="VerifyCodeServlet" class="verifyCode"  alt="verifyCode"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input class="submitButton" type="submit" value="注册">
                </td>
            </tr>
        </table>
    </div>
</body>
</html>