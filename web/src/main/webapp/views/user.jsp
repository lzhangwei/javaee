<%--
  Created by IntelliJ IDEA.
  User: weizhang
  Date: 7/8/15
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="lib/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="lib/js/user.js"></script>
</head>
<body>
<a href="/web/logout">退出登录</a>

<form method="POST" action="/web/users" id="addUser">
    姓名 : <input
        type="text" name="name" id="userName"/> <br/>
    性别 : <input
        type="text" name="gender" id="userGender"/> <br/>
    邮箱 : <input
        type="text" name="email" id="userEmail"/> <br/>
    年龄 : <input type="text" name="age" id="userAge"/> <br/>
    密码 : <input type="text" name="password" id="userPassword"/> <br/>
    <input type="text" id="userId" name="id" hidden="hidden"/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
