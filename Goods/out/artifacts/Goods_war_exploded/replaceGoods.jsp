<%--
  Created by IntelliJ IDEA.
  User: WJ
  Date: 2021/2/23
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改商品</title>
    <style>
        form{
            width: 370px;
            height: 220px;
            margin: 100px auto 0;
            display: flex;
            flex-direction: row;
            justify-content: space-between;
        }
        label{
            width: 40px;
            display: inline-block;
        }
        div{
            margin: 0 auto ;
            width: 222px;
        }
        input:focus{
            outline: none;
        }
        img{
            width: 80px;
            height: 80px;
            background-color: white;
            margin: 0 auto;
            display: block;
        }
        .c_1{
            width: 140px;
            height: 140px;
            display: flex;
            flex-direction: column;
            justify-content: center;
        }
        .input_file{
            margin: 10px auto;
        }
    </style>
    <script src="/js/jquery-1.9.1.min.js"></script>
</head>
<body>
<%--在表单中加上onsubmit="return false;"可以阻止表单提交。--%>
<%--商品图片展示--%>

<form action="/goods/update" method="post" enctype="multipart/form-data">
    <div class="c_1">
        <img src="${good.image}" alt="">
    </div>
    <div class="c_2">
        <input style="width: 240px;border: none" type="text" name="id" value="${good.id}" readonly>
        <label>名称</label><input style="margin-top: 20px;" autocomplete="off" name="title" type="text" placeholder="${good.title}" value="${good.title}">
        <label>价格</label><input style="margin-top: 20px;"  autocomplete="off" name="price" type="text" placeholder="${good.price}" value="${good.price}">
        <input class="input_file" name="image" type="file" value="${good.image}">
        <div style="width: 224px;height: 70px;">
            <input style="display: block;margin: 0 auto ;" type="submit" placeholder="确认修改">
        </div>
    </div>


</form>

</body>
</html>
