<%@ page import="cn.edu.ArithmeticTester.entity.TestResult" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: prinzeugen
  Date: 2021/12/23
  Time: 10:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学员近期练习情况</title>
    <link rel="stylesheet" href="css/testResultOfStudent.css">
</head>
<body>
<%
    ArrayList<TestResult> testResults = (ArrayList<TestResult>) session.getAttribute("testResults");
    String studentName = (String) session.getAttribute("studentName");
%>
    <div class="content">
        <a href="guardianHome.jsp" class="back">返回</a>
        <h1><%=studentName%>近期练习情况</h1>
        <div class="textInfo">
            <table>
                <tr>
                    <th>
                        <p>作业号</p>
                    </th>
                    <th>
                        <p>总题数</p>
                    </th>
                    <th>
                        <p>错误题数</p>
                    </th>
                    <th>
                        <p>分数</p>
                    </th>
                </tr>
                <%
                    if (testResults != null){
                        for (TestResult testResult: testResults) {
                            int id = testResult.getId();
                            int forumNum = testResult.getForumNum();
                            int mistake = testResult.getMistake();
                            double accuracy = testResult.getAccuracy();
                            System.out.println("id="+id);
                            System.out.println("forumNum="+forumNum);
                            System.out.println("mistake="+mistake);
                            System.out.println("accuracy="+accuracy);
                %>
                <tr>
                    <td>
                        <p><%=id%></p>
                    </td>
                    <td>
                        <p><%=forumNum%></p>
                    </td>
                    <td>
                        <p><%=mistake%></p>
                    </td>
                    <td>
                        <p><%=accuracy*100%>分</p>
                    </td>
                </tr>
                <%
                        }
                    } else{

                %>
                <tr>
                    <td colspan="3">
                        <p>您的孩子最近没有答题记录呢</p>
                    </td>
                </tr>
                <%
                        }
                %>
            </table>
        </div>
    </div>
</body>
</html>
