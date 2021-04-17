<%--
  Created by IntelliJ IDEA.
  User: WJ
  Date: 2021/2/20
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>
        form{
            width: 300px;
            height: 300px;
            margin: 100px auto;
            background: bisque;
        }
        label{
            display: inline-block;
            width: 80px;
        }
        div{
            margin: 20px auto 0px;
            display: flex;
            justify-content: center;
            flex-direction: row;
        }
        .d1{
            padding-top: 50px;
        }
        .d3>input{
            display: block;
            margin: 40px auto 0px;
        }
        input{
            outline: none;
        }
    </style>
    <script src="js/jquery-1.9.1.min.js"></script>
</head>
<body>
<%--在表单中加上onsubmit="return false;"可以阻止表单提交。--%>
<form onsubmit="return false;">
        <div class="d1">
            <label>用户名</label><input autocomplete="off" name="nickname" type="text" placeholder="请输入用户名">
        </div>
        <div class="d2">
            <label>密码</label><input autocomplete="off" name="password" type="password"  placeholder="请输入密码">
        </div>
        <div style="color: red;margin: 0 auto" name="hidden_1"></div>
        <div class="d3"><input onclick="handlerLoginClick()" type="submit" value="登录"></div>
</form>
<script>
    function handlerLoginClick() {
        /*const nickname = $("input[name='nickname']").val();
        const password = $("input[name='password']").val();*/
        $.ajax({
            url: "/login",
            type: "POST",
            data: $("form").serialize(),
            success(resp) {
                console.log(resp)
                /*校验成功*/
                if (resp.code === 666) {
                    /*重定向*/
                    alert("登陆成功")
                    window.location.href = "/goods/page?currentPage=1&size=5"
                }else {
                    $("div[name='hidden_1']").text("账号或密码错误")
                }
            }
        })

    }
</script>
</body>
</html>
