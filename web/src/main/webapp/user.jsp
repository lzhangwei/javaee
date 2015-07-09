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
</head>
<body>
<form method="POST" action='UserServlet' name="addUser">
    姓名 : <input
        type="text" name="name"
        value="<c:out value="${user.name}" />"/> <br/>
    性别 : <input
        type="text" name="gender"
        value="<c:out value="${user.gender}" />"/> <br/>
    邮箱 : <input
        type="text" name="email"
        value="<c:out value="${user.email}" />"/> <br/>
    年龄 : <input type="text" name="age"
                value="<c:out value="${user.age}" />"/> <br/>
    <input type="text" readonly="readonly" name="userId" hidden="hidden"
           value="<c:out value="${user.id}" />"/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
