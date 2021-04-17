<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: WJ
  Date: 2021/2/22
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品列表</title>
    <link rel="stylesheet" type="text/css" href="//at.alicdn.com/t/font_2336024_n1qcjkeqri.css">
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
        .head_2>.icon-tianjia{
            width: 100px;
            margin-top: 10px;
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
        .head_2_1{
            display: flex;
            flex-direction: row;
            justify-content: center;
            width: 190px;
            height: 32px;
        }
        .head_2_2{
            width: 80px;
            margin-top: 10px;
            margin-left: 10px;
        }
        .input_search:focus,.footer_input{
            outline: none;
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
    <%--遇到ReferenceError: $ is not defined,改一下引入路径--%>
    <script src="/js/jquery-1.9.1.min.js"></script>
</head>
<body>
<div class="head">
    <div class="head_1">商品列表</div>
    <div class="head_2">
        <div class="head_2_1">
            <input class="input_search" style="margin-top: 10px;" name="searchTitle" type="search" placeholder="请输入你想要搜索的商品" >
            <a class="iconfont icon-sousuo" onclick="searchGoods()" ></a>
        </div>
        <div class="head_2_2">
            <a href="/member.jsp" class="iconfont icon-xingmingyonghumingnicheng">
                ${sessionScope.nickname}
            </a>
        </div>
        <a class="iconfont icon-tianjia" href="/addGoods.jsp">添加商品</a>
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
    <c:forEach items="${pageMap.goodList}" var="good">
        <tr>
            <td>${good.id}</td>
            <td>${good.title}</td>
            <td><img src="${good.image}" alt=""></td>
            <td>${good.price/100}</td>
            <td><button class="a_del" type="button" onclick="handlerDeleteGoodsClick('${good.id}',${pageMap.currentPage})">删除</button></td>
            <td><button class="a_del" type="button" onclick="handlerReplaceGood('${good.id}')">修改</button></td>
        </tr>
    </c:forEach>
</table>
<div class="footer">
    <c:if test="${pageMap.currentPage != 1}">
    <div style="width: 40px;height: 26px;margin-right: 60px;border: 1px solid black;background-color: #ffe4c4;">
        <button style="margin: 0 auto;display: block;width: 40px;height: 26px;line-height: 26px;border: none" onclick="tag(1)">首页</button>
    </div>
    </c:if>
    <c:if test="${pageMap.currentPage == 1}">
        <div style="width: 66px;height: 26px;margin-right: 60px;border: 1px solid black;background-color: #ffe4c4;">
            <button style="margin: 0 auto;display: block;width: 66px;height: 26px;line-height: 26px;border: none" >已是首页</button>
        </div>
    </c:if>
    <c:if test="${pageMap.currentPage != 1}">
    <div style="width: 56px;height: 26px;border: 1px solid black;background-color: #ffe4c4;">
        <button style="margin: 0 auto;display: block;width: 56px;height: 26px;line-height: 26px;border: none"  onclick="pre(${pageMap.currentPage})">上一页</button>
    </div>
    </c:if>
    <c:if test="${pageMap.currentPage == 1}">
        <div style="width: 80px;height: 26px;border: 1px solid black;background-color: #ffe4c4;">
            <button style="margin: 0 auto;display: block;width: 80px;height: 26px;line-height: 26px;border: none" >已是第一页</button>
        </div>
    </c:if>
        <div style="margin: 0 auto;line-height: 26px;width: 120px;">${pageMap.currentPage}/${pageMap.totalPage}</div>
    <c:if test="${pageMap.currentPage != pageMap.totalPage}">
    <div style="width: 56px;height: 26px;border: 1px solid black;background-color: #ffe4c4;">
        <button style="margin: 0 auto;display: block;width: 56px;height: 26px;line-height: 26px;border: none"  onclick="next(${pageMap.currentPage})">下一页</button>
    </div>
    </c:if>
    <c:if test="${pageMap.currentPage == pageMap.totalPage}">
        <div style="width: 92px;height: 26px;border: 1px solid black;background-color: #ffe4c4;">
            <button style="margin: 0 auto;display: block;width: 92px;height: 26px;line-height: 26px;border: none">已是最后一页</button>
        </div>
    </c:if>
    <c:if test="${pageMap.currentPage != pageMap.totalPage}">
    <div style="width: 40px;height: 26px;margin-left: 60px;border: 1px solid black;background-color: #ffe4c4;">
        <button style="margin: 0 auto;display: block;width: 40px;height: 26px;line-height: 26px;border: none;" onclick="tag(${pageMap.totalPage})">尾页</button>
    </div>
    </c:if>
    <c:if test="${pageMap.currentPage == pageMap.totalPage}">
        <div style="width: 66px;height: 26px;margin-left: 60px;border: 1px solid black;background-color: #ffe4c4;">
            <button style="margin: 0 auto;display: block;width: 66px;height: 26px;line-height: 26px;border: none;">已是尾页</button>
        </div>
    </c:if>
</div>
<div style="margin: 0 auto;width: 1096px;" class="footer_lastDiv">

    <div name="hidden" style="color: #fc5531;margin: 0 auto;width:180px"></div>
    <div style="margin: 0 auto;width: 260px;">
        <div style="width: 140px;height: 22px;margin: 0 auto;">
            <label>跳转到第</label>
            <input name="anyPage" style="display: inline-block;width: 40px;height: 20px" class="footer_input" type="search  " onkeypress="handlerAnyPage()">
            <label>页</label>
        </div>
    </div>
</div>
<div class="hidden_last" onclick="tag(1)">返回首页</div>
<script>

    //查找
    function searchGoods() {
        $.ajax({
            url: "/goods/search?title=" + $("input[name='searchTitle']").val(),
            type: "post",
            success() {
                window.location.href = "/searchGoods.jsp"
            }
        })

    }

    //跳转指定页
    function handlerAnyPage() {
            const page = $("input[name='anyPage']").val()
            if (0 > page||page > ${pageMap.totalPage}) {
                $("div[name = 'hidden']").text("输入页数有误,请重新输入")
        }else {
                window.location.href = "/goods/page?currentPage=" + page + "&size=5"
        }
    }

    //上一页
    function pre(currentPage) {

        currentPage -= 1;
        window.location.href = "/goods/page?currentPage=" + currentPage + "&size=5"

    }

    //下一页
    function next(currentPage) {

        currentPage += 1;
        window.location.href = "/goods/page?currentPage=" + currentPage + "&size=5"

    }

    //首页/尾页
    function tag(currentPage) {

        window.location.href = "/goods/page?currentPage=" + currentPage + "&size=5"

    }

    //删除
    function handlerDeleteGoodsClick(id,page) {
        $.ajax({
            url: "/goods/delete?id=" + id,
            type: "post",
            success(resp) {
                //删除成功
                if (resp === "isDeleted") {
                    window.location.href = "/goods/page?currentPage=" + page + "&size=5"
                }
            }
        })
    }

    //修改
    function handlerReplaceGood(id) {
        window.location.href = "/goods/replace?id=" + id
    }
</script>
</body>
</html>
