<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/8/8
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>中南大学阳光体育后台管理系统首页</title>
    <meta name="keywords" content="中南大学,中南大学阳光体育" />
    <meta name="description" content="中南大学,中南大学阳光体育" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- bootstrap -->
    <link href="css/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />

    <!-- libraries -->
    <link href="css/lib/jquery-ui-1.10.2.custom.css" rel="stylesheet" type="text/css" />
    <link href="css/lib/font-awesome.css" type="text/css" rel="stylesheet" />
    <link href="css/lib/uniform.default.css" type="text/css" rel="stylesheet">
    <link href="css/lib/select2.css" type="text/css" rel="stylesheet">
    <link href="css/lib/bootstrap.datepicker.css" type="text/css" rel="stylesheet">

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="css/compiled/layout.css">
    <link rel="stylesheet" type="text/css" href="css/compiled/elements.css">
    <link rel="stylesheet" type="text/css" href="css/compiled/icons.css">

    <!-- this page specific styles -->
    <link rel="stylesheet" href="css/compiled/form-showcase.css" type="text/css" media="screen" />
    <%--<!-- this page specific styles -->--%>
    <%--<link rel="stylesheet" href="css/compiled/index.css" type="text/css" media="screen" />--%>

    <!-- open sans font -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- lato font -->
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css'>

    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>
<!-- navbar -->
<header class="navbar navbar-inverse" role="banner">
    <div class="navbar-header">
        <button class="navbar-toggle" type="button" data-toggle="collapse" id="menu-toggler">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index.html"><img src="img/logo.png"></a>
    </div>
    <ul class="nav navbar-nav pull-right hidden-xs">
        <li class="hidden-xs hidden-sm">
            <input class="search" type="text" />
        </li>
        <li class="notification-dropdown hidden-xs hidden-sm">
            <a href="#" class="trigger">
                <i class="icon-warning-sign"></i>
                <span class="count">8</span>
            </a>
            <div class="pop-dialog">
                <div class="pointer right">
                    <div class="arrow"></div>
                    <div class="arrow_border"></div>
                </div>
                <div class="body">
                    <a href="#" class="close-icon"><i class="icon-remove-sign"></i></a>
                    <div class="notifications">
                        <h3>你有1条信息</h3>
                        <a href="#" class="item">
                            <i class="icon-signin"></i> 资料审核成功
                            <span class="time"><i class="icon-time"></i> 13分钟前.</span>
                        </a>
                        <a href="#" class="item">
                            <i class="icon-signin"></i> 资料审核成功
                            <span class="time"><i class="icon-time"></i> 18分钟前.</span>
                        </a>
                        <a href="#" class="item">
                            <i class="icon-envelope-alt"></i> 资料审核成功
                            <span class="time"><i class="icon-time"></i> 28分钟前.</span>
                        </a>
                        <a href="#" class="item">
                            <i class="icon-signin"></i> 资料审核成功
                            <span class="time"><i class="icon-time"></i> 49分钟前.</span>
                        </a>
                        <a href="#" class="item">
                            <i class="icon-download-alt"></i> 资料审核成功
                            <span class="time"><i class="icon-time"></i> 1天前.</span>
                        </a>
                        <div class="footer">
                            <a href="#" class="logout">查看所有消息</a>
                        </div>
                    </div>
                </div>
            </div>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle hidden-xs hidden-sm" data-toggle="dropdown">
                我的信息
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
                <li><a href="<%=request.getContextPath()%>/basicInfo">基本信息</a></li>
                <li><a href="#">家长信息</a></li>
                <li><a href="#">奖励情况</a></li>
                <li><a href="#">挂科情况</a></li>
                <li><a href="#">退队说明</a></li>
                <li><a href="#">退出登录</a></li>
            </ul>
        </li>
        <li class="settings hidden-xs hidden-sm">
            <a href="personal-info.html" role="button">
                <i class="icon-cog"></i>
            </a>
        </li>
        <li class="settings hidden-xs hidden-sm">
            <a href="signin.html" role="button">
                <i class="icon-share-alt"></i>
            </a>
        </li>
    </ul>
</header>
<!-- end navbar -->

<!-- sidebar -->
<div id="sidebar-nav">
    <ul id="dashboard-menu">
        <li class="active">
            <div class="pointer">
                <div class="arrow"></div>
                <div class="arrow_border"></div>
            </div>
            <a href="index.html">
                <i class="icon-home"></i>
                <span>首页</span>
            </a>
        </li>
        <li>
            <a class="dropdown-toggle" href="#">
                <i class="icon-cog"></i>
                <span>我的信息</span>
                <i class="icon-chevron-down"></i>
            </a>
            <ul class="submenu">
                <li><a href="<%=request.getContextPath()%>/basicInfo">基本信息</a></li>
                <li><a href="new-user.html">家长信息</a></li>
                <li><a href="user-profile.html">奖励情况</a></li>
                <li><a href="#">挂科情况</a></li>
                <li><a href="#">退队说明</a></li>
            </ul>
        </li>
        <li>
            <a href="#">
                <i class="icon-edit"></i>
                <span>审核状态</span>
            </a>
        </li>
    </ul>
</div>
<!-- end sidebar -->
<!-- main container -->
<div class="content">

    <!-- settings changer -->
    <div class="skins-nav">
        <a href="#" class="skin first_nav selected">
            <span class="icon"></span><span class="text">Default</span>
        </a>
        <a href="#" class="skin second_nav" data-file="css/compiled/skins/dark.css">
            <span class="icon"></span><span class="text">Dark skin</span>
        </a>
    </div>