<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--在jsp页面中引入和使用jstl标签库,即可使用EL表达式--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

用户名<input type="text" placeholder="${user.name}" ><br>
用户名<input type="password" placeholder="${user.age}">
<br>
<button rel="#">确认登陆</button>
</body>
</html>