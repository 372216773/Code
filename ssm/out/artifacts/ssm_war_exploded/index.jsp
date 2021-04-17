<%--
  Created by IntelliJ IDEA.
  User: WJ
  Date: 2021/4/14
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%--不忽略EL表达式--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--- 核心标签库一般使用c作为前缀，所以我们也称核心标签库为c标签。
　　　 c标签是我们JSTL中最常用的一个标签库，它里边封装了很多开发中常用的功能。--%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  ${user.name}
  </body>
</html>
