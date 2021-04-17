<%--
  Created by IntelliJ IDEA.
  User: WJ
  Date: 2021/2/24
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
    <style>
        h1{
            text-align: center;
        }
        table{
            margin: 0 auto;
            border-collapse:collapse;
        }
        td{
            width: 100px;
            font-size: 20px;
        }
        tr{
            display: block;
            margin-top: 20px;
        }
        input{
            width: 400px;
        }
        tr
    </style>
    <script src="./js/jquery-1.9.1.min.js"></script>
</head>
<body>
<h1>添加商品</h1>
<form  action="/goods/add" method="post" enctype="multipart/form-data" >
    <table>
        <tr>
            <td>名称</td>
            <td>
                <input name="title" type="text">
            </td>
        </tr>

        <tr>
            <td>价格</td>
            <td><input name="price" type="text"></td>
        </tr>

        <tr>
            <td>商品图片</td>
            <td><input name="image" type="file"></td>
        </tr>

        <tr>
            <td></td>
            <td><button type="submit" >确认添加</button></td>
        </tr>
    </table>
</form>


<script>
</script>
</body>
</html>

