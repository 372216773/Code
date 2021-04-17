<%--
  Created by IntelliJ IDEA.
  User: WJ
  Date: 2021/2/20
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>商品管理系统</title>
    <link rel="icon" href="">
    <style>

      a:link {
        text-decoration: none;
      } /* 未访问的链接 */
      a:visited {
        text-decoration: none;
      } /* 已访问的链接 */
      a:hover {
        text-decoration: none;
      } /* 鼠标移动到链接上 */
      a:active {
        text-decoration: none;
      } /* 选定的链接，即鼠标按下去的时候不松开显示的状态 */
      form{
        width: 300px;
        height: 300px;
        margin: 100px auto 0px;
      }
      a{
        text-decoration: none;
        /*	inline-block:行内块级元素*/
        display: inline-block;
        width: 300px;
        height: 140px;
        margin-top: 10px;
        background: bisque;
        font-size: larger;
        text-align: center;
        line-height: 140px;
      }
    </style>
  </head>
  <body>
  <form action="">
    <a href="./login.jsp">登录</a>
    <a href="./register.jsp">注册</a>
  </form>
  </body>
</html>
