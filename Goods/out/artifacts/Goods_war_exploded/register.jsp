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
    <title>注册</title>
    <style>
        form{
            width: 300px;
            height: 300px;
            background: aliceblue;
            margin: 100px auto;
            display: block;
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
        .d3>select{
            display: inline-block;
            width: 85px;
        }
        .d4>input{
            display: block;
            width: 260px;
            margin: 0 auto;
        }
        .d5>input{
            display: block;
            margin: 0 auto;
        }
        input{
            outline: none;
        }
    </style>
    <%--引入js--%>
    <script src="./js/jquery-1.9.1.min.js"></script>
</head>
<body>
<form method="post" onsubmit="return false;">

    <div class="d1">
        <label>用户名</label><input autocomplete="off" name="nickname" type="text" placeholder="请输入用户名">
    </div>
    <div class="d2">
        <label>密码</label><input autocomplete="off" name="password" type="text" placeholder="请输入密码">
    </div>

    <div class="d3">
        <label>地址</label>
        <%--返回id--%>
        <select name="province" onchange="handlerProvinceChange(this.value)"></select>
        <select name="city"></select>
    </div>

    <div class="d4">
        <input autocomplete="off" name="extra" type="text" placeholder="请输入具体街道门牌号">
    </div>

    <div class="d5">
        <input type="submit" value="立即注册" onclick="handlerRegisterRequest()">
    </div>
        <div style="color: red;margin: 0 auto" name="hidden_1"></div>
</form>
<script>
    /**
     * 处理返回的pid值
     * 查询pid对应的所有城市,然后返回给city
     * @param value
     */
    function handlerProvinceChange(value) {

        /*清空选择属性的所有值*/
        $("select[name='city']").empty();
        $.ajax({
            /*重定向到指定地址进行操作*/
            url: "city/listByPid?pid="+value,
            /*success 当请求之后调用。传入返回后的数据，以及包含成功代码的字符串。*/
            success(resp) {
                console.log(resp)
                for (const i in resp) {
                    /*选择为select标签且name为city的标签*/
                    $("select[name='city']").append("<option value='"+resp[i].id+"'>" + resp[i].name + "</option>")
                }
            }
        })
    };
    /*在页面框架下载完毕后就执行*/
    $(function () {

        //js请求
        $.ajax({
            url: "/province/list",
            success(resp) {
                for (const i in resp) {
                    $("select[name='province']").append("<option value='"+resp[i].id+"'>"+resp[i].name+"</option>")

                    /*返回第一个省份的时候,直接输出所有的相关城市*/
                    if (i == 0) {

                        $.ajax({
                            /*i是数组遍历的值,不是pid值*/
                            url: "/city/listByPid?pid=1",
                            success(resp) {
                                for (const i in resp) {
                                    $("select[name='city']").append("<option value='"+resp[i].id+"'>"+resp[i].name+"</option>")
                                }
                            }
                        })

                    }
                }
            }
        })

    })
    function handlerRegisterRequest() {
        $.ajax({
            url: "/register",
            type: "POST",
            /*携带表单值到/register*/
            data: $("form").serialize(),
            success(resp) {
                //存在
                if (resp === "false") {
                    $("div[name='hidden_1']").text("已存在此账号,请重新输入账号与密码")
                }else {
                    alert("注册成功")
                    window.location.href = "/login.jsp"
                }
            }
        })
    }
</script>
</body>
</html>
