<%--
  Created by IntelliJ IDEA.
  User: WJ
  Date: 2021/2/22
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户中心</title>
    <style>
        form{
            width: 300px;
            height: 300px;
            margin: 100px auto 0;
            background: #ffe4c4;
        }
        label{
            width: 40px;
            display: inline-block;
        }
        div{
            margin: 20px auto 0;
            width: 212px;
        }
        .submit{
            margin: 0 auto;
            display: block;
        }
        .div_1{
            margin: 0 auto 40px;
            width: 300px;
            height: 20px;
            text-align: center;
            line-height: 20px;
        }
        input{
            outline: none;
        }
    </style>
</head>
<body>
<%--在表单中加上onsubmit="return false;"可以阻止表单提交。--%>
<%--商品图片展示--%>

<form method="post" onsubmit="return false;">
    <div class="div_1">修改个人信息</div>
    <div>
        <label for="">名称</label><input autocomplete="off" name="nickname" type="text" placeholder="请输入名称">
    </div>
    <div>
        <label for="">地址</label><input autocomplete="off" name="address" type="text" placeholder="请输入地址">
    </div>
    <div>
        <label for="">密码</label><input autocomplete="off" name="password" type="password" placeholder="请输入密码">
    </div>
    <div>
        <input class="submit" type="submit" placeholder="确认修改">
    </div>

</form>
</body>
</html>
