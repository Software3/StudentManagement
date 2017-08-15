<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/8/11
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html class="login-bg">
<head>
    <title>中南大学阳光体育后台管理系统首页</title>
    <meta name="keywords" content="中南大学,中南大学阳光体育" />
    <meta name="description" content="中南大学,中南大学阳光体育" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- bootstrap -->
    <link href="css/bootstrap/bootstrap.css" rel="stylesheet">
    <link href="css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet">

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="css/compiled/layout.css">
    <link rel="stylesheet" type="text/css" href="css/compiled/elements.css">
    <link rel="stylesheet" type="text/css" href="css/compiled/icons.css">

    <!-- libraries -->
    <link rel="stylesheet" type="text/css" href="css/lib/font-awesome.css">

    <!-- open sans font -->
    <%--<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>--%>

    <![endif]-->
</head>
<body>


<!-- background switcher -->
<%--<div class="bg-switch visible-desktop">--%>
    <%--<div class="bgs">--%>
        <%--<a href="#" data-img="landscape.jpg" class="bg active">--%>
            <%--<img src="img/bgs/landscape.jpg" />--%>
        <%--</a>--%>
        <%--<a href="#" data-img="blueish.jpg" class="bg">--%>
            <%--<img src="img/bgs/blueish.jpg" />--%>
        <%--</a>--%>
        <%--<a href="#" data-img="7.jpg" class="bg">--%>
            <%--<img src="img/bgs/7.jpg" />--%>
        <%--</a>--%>
        <%--<a href="#" data-img="8.jpg" class="bg">--%>
            <%--<img src="img/bgs/8.jpg" />--%>
        <%--</a>--%>
        <%--<a href="#" data-img="9.jpg" class="bg">--%>
            <%--<img src="img/bgs/9.jpg" />--%>
        <%--</a>--%>
        <%--<a href="#" data-img="10.jpg" class="bg">--%>
            <%--<img src="img/bgs/10.jpg" />--%>
        <%--</a>--%>
        <%--<a href="#" data-img="11.jpg" class="bg">--%>
            <%--<img src="img/bgs/11.jpg" />--%>
        <%--</a>--%>
    <%--</div>--%>
<%--</div>--%>


<div class="login-wrapper">
    <a href="">
        <img class="logo" src="img/logo-s.png">
    </a>

    <div class="box">
        <div class="content-wrap">
            <h6>登录</h6>
            <form id="loginForm" method="post" name="f" action="${loginUrl}">
                <input id="account" name="username" class="form-control" type="text" placeholder="学号">
                <input id="password" name="password" class="form-control" type="password" placeholder="密码">
                <%--<input type="radio" name="type" id="optionsRadios1" value="0" onclick="whichLogin()">--%>
                <%--学生登录--%>
                <%--<input type="radio" name="type" id="optionsRadios2" value="1" onclick="whichLogin()">--%>
                <%--教师登录--%>
                <%--<a href="#" class="forgot">忘记密码?</a>--%>
                <%--<div class="remember">--%>
                    <%--<input id="remember-me" type="checkbox">--%>
                    <%--<label for="remember-me">记住密码</label>--%>
                <%--</div>--%>
                <%--<input type="hidden"name="${_csrf.parameterName}"value="${_csrf.token}"/>--%>
                <button class="btn-glow primary login" id="login" type="submit">登录</button>
            </form>
        </div>
    </div>

    <%--<div class="no-account">--%>
        <%--<p>还没账号?</p>--%>
        <%--<a href="signup.html">注册</a>--%>
    <%--</div>--%>
</div>

<!-- this page specific styles -->
<link rel="stylesheet" href="css/compiled/signin.css" type="text/css" media="screen" />
<!-- scripts -->
<%--<script src="http://code.jquery.com/jquery-latest.js"></script>--%>
<%--<script src="js/bootstrap.min.js"></script>--%>
<script src="js/theme.js"></script>
<script src="js/util/userUtil.js"></script>
<!-- pre load bg imgs -->
<%--<script type="text/javascript">--%>
    <%--function whichLogin() {--%>
        <%--var type=$('input[name="type"]:checked').val();--%>
        <%--if(type==0){--%>
            <%--window.location.href = '<%=request.getContextPath()%>/';--%>
        <%--}else{--%>
            <%--window.location.href = '<%=request.getContextPath()%>/teacherhome';--%>
        <%--}--%>
    <%--}--%>
    <%--$(function () {--%>
        <%--// bg switcher--%>
        <%--var $btns = $(".bg-switch .bg");--%>
        <%--$btns.click(function (e) {--%>
            <%--e.preventDefault();--%>
            <%--$btns.removeClass("active");--%>
            <%--$(this).addClass("active");--%>
            <%--var bg = $(this).data("img");--%>

            <%--$("html").css("background-image", "url('img/bgs/" + bg + "')");--%>
        <%--});--%>

        <%--// login--%>
        <%--$("#login").click(function () {--%>
            <%--var account = $("#account").val()--%>
            <%--var password = $("#password").val();--%>
            <%--var type = $("input:radio:checked").val();--%>
            <%--if (!account) {--%>
                <%--console.log("用户名不能为空");--%>
                <%--return false;--%>
            <%--}--%>
            <%--if (!password) {--%>
                <%--console.log("密码不能为空");--%>
                <%--return false;--%>
            <%--}--%>

<%--//            $("#loginForm").submit();--%>
            <%--var json = {account: account, password: password, type: type};--%>
            <%--$.ajaxSetup({contentType: 'application/json'});--%>
            <%--$.ajax({--%>
                <%--url: 'loginCheck',--%>
                <%--dataType: 'json',--%>
                <%--method: 'POST',--%>
                <%--data: JSON.stringify(json),--%>
                <%--success: function (data) {--%>
                    <%--var result = data.object;--%>
                    <%--if (result == undefined) {--%>
                        <%--console.log("登录失败，请重试");--%>
                        <%--return;--%>
                    <%--}--%>
                    <%--if (type == 0) {--%>
                        <%--result.userid = result.studentId;--%>
                        <%--saveStudent(result);--%>
                        <%--window.location.href = '<%=request.getContextPath()%>/shome?userid=' + getStudentId();--%>
                        <%--return;--%>
                    <%--} else if (type == 1) {--%>
                        <%--saveTeacher(result);--%>
                        <%--window.location.href = '<%=request.getContextPath()%>/teacherhome?teacherId=' + getTeacherId();--%>
                        <%--return;--%>
                    <%--}--%>
                <%--},--%>
                <%--error: function (xhr) {--%>

                <%--}--%>
            <%--})--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>
</body>
</html>
