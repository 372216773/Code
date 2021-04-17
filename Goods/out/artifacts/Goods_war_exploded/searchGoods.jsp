<%--
  Created by IntelliJ IDEA.
  User: WJ
  Date: 2021/2/24
  Time: 2:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>搜索到的商品</title>
    <style>
        table{
            margin: 0 auto;
            width: 1096px;
        }
        td{
            text-align: center;
            height: 80px;
            width: 80px;
        }
        .head{
            height: 40px;
            width: 1096px;
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            margin: 100px auto 10px;
            background-color: bisque;
        }
        .head_1{
            margin: 10px auto;
            padding-left: 350px;
            font-weight: bolder;
        }
        .head_2{
            width: 350px;
            height: 40px;
            display: flex;
            flex-direction: row;
            justify-content: space-between;
        }
        img{
            width: 80px;
            height: 80px;
        }
        a:visited{
            color: black;
        }
        a{
            text-decoration: none;
        }
        .a_del{
            width: 50px;
            height: 25px;
            background-color: bisque;
            color: #fc5531;
            border: 1px solid black;
        }
        .a_del:hover{
            cursor: pointer;
        }
        .a_del:focus{
            outline: none;
        }
        .head_2_1>.icon-sousuo{
            margin-left: -1px;
            margin-top: 10px;
            background-color: white;
            display: block;
            font-size: 17px;
            border: 1px solid #767676;
        }
        .head_2_2{
            width: 80px;
            margin-top: 10px;
            margin-left: 10px;
        }
        .footer{
            width: 1096px;
            height: 40px;
            display: flex;
            flex-direction: row;
            justify-content: center;
            margin: 20px auto 0;
        }
        button:focus{
            outline: none;
        }
        button:hover{
            cursor: pointer;
        }
    </style>

    <link rel="stylesheet" type="text/css" href="//at.alicdn.com/t/font_2336024_n1qcjkeqri.css">
    <script src="js/jquery-1.9.1.min.js"></script>
</head>
<body>
<div class="head">
    <div class="head_1">商品列表</div>
    <div class="head_2">
        <div class="head_2_2">
            <a href="./member.jsp" class="iconfont icon-xingmingyonghumingnicheng">
<%--                ${sessionScope.nickname}--%>
            </a>
        </div>
    </div>
</div>
<table border="1px" cellpadding="0px" cellspacing="0px">
<tr>
    <td>商品编号</td>
    <td>名称</td>
    <td>图片</td>
    <td>价格</td>
    <td colspan="2">操作</td>
    <%--        <td>操作</td>--%>
</tr>
<c:forEach items="${goodMap.goodList}" var="good">
    <tr>
        <td>${good.id}</td>
        <td>${good.title}</td>
        <td><img src="${good.image}" alt=""></td>
        <td>${good.price/100}</td>
        <td><button class="a_del" type="button" onclick="handlerDeleteGoodsClick('${good.id}')">删除</button></td>
        <td><button class="a_del" type="button" onclick="handlerReplaceGood('${good.id}')">修改</button></td>
    </tr>
</c:forEach>
</table>
<div class="hidden_last" ><a href="./goods.jsp">返回</a></div>
</body>
<script>
    //删除
    function handlerDeleteGoodsClick(id) {
        $.ajax({
            url: "/goods/delete?id=" + id,
            type: "post",
            success(resp) {
                //删除成功
                if (resp === "isDeleted") {
                    window.location.href = "/goods/page?currentPage=1&size=5"
                }
            }
        })
    }
</script>
</html>
