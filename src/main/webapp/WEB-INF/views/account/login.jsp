<%--
  Created by IntelliJ IDEA.
  User: livvy
  Date: 14-5-10
  Time: 下午1:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../taglib.jsp"%>
<html>
<head>
    <title>登录</title>
</head>
<body>
     <form:form commandName="user" method="post" action="dologin">
         <form:label path="name">用户名：</form:label><form:input path="name" />
         <form:label path="password">密码</form:label><form:password path="password"/>
         <input type="submit">
     </form:form>
</body>
</html>
