#ArithmeticTester - 小学三年级四则运算练习平台 #
## 简介 ##
该系统使用Maven构建，使用jsp和servlet开发，可以实现简单的小学三年级的四则运算测试。
在家长账户可以查看孩子的所有练习记录。

由于水平有限，本系统没有采用vue等前端框架和JFinal或Spring Boot等web框架。
本系统尚未完成验证码刷新功能、计时功能，以及应对非法值输入还略有不足，忘谅解。

## 页面说明 ##
### guardianHome ###
家长账户主页，这里可以查看连接的孩子账户的练习信息
### index ###
系统最初的登录页面
### newTest ###
生产新测试的页面，可以指定运算规则和题目数量
### register ###
用户注册页面
### studentHome ###
学生主页，可以在这里开始新测试（跳转到newTest.jsp）
### testPage ###
一场测试进行时的页面
### testResult ###
测试结束时，显示测试结果的页面
### testResultOfStudent ###
显示指定孩子账户的所有练习信息