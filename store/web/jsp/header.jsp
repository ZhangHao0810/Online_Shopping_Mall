<%--
  Created by IntelliJ IDEA.
  User: ZhangHao
  Date: 2019/11/13
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--
            	描述：菜单栏
            -->
<div class="container-fluid">
    <div class="col-md-4">
        <img src="${pageContext.request.contextPath}/img/logo2.png" />
    </div>
    <div class="col-md-5">
        <img src="${pageContext.request.contextPath}/img/header.png" />
    </div>
    <div class="col-md-3" style="padding-top:20px">
        <ol class="list-inline">
            <li><a href="${pageContext.request.contextPath}/jsp/login.jsp">登录</a></li>
            <li><a href="${pageContext.request.contextPath}/UserServlet?method=registUI">注册</a></li>
            <li><a href="${pageContext.request.contextPath}/jsp/cart.jsp">购物车</a></li>
            <li><a href="${pageContext.request.contextPath}/jsp/order_list.jsp">我的订单</a></li>
        </ol>
    </div>
</div>
<!--
    描述：导航条
-->
<div class="container-fluid">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">首页</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${pageContext.request.contextPath}/jsp/product_list.jsp">手机数码<span class="sr-only">(current)</span></a></li>
                    <li><a href="#">电脑办公</a></li>
                    <li><a href="#">电脑办公</a></li>
                    <li><a href="#">电脑办公</a></li>
                </ul>
                <form class="navbar-form navbar-right" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>

            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
</div>
</body>
</html>
